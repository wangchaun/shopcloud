package com.maiya.shopcloud.base.mybatis;

import com.maiya.shopcloud.base.pagination.Page;
import com.maiya.shopcloud.base.pagination.dialect.DBPageDialect;
import com.maiya.shopcloud.base.pagination.dialect.DBPageDialectFactory;
import com.maiya.shopcloud.base.pagination.dialect.DBPageDialectType;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 老规矩，签名里要拦截的类型只能是接口。
 * 
 * @author  mandy.hu
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare",  args = { Connection.class,Integer.class }) })
public class PageInterceptor implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY=new DefaultReflectorFactory();
	private static DBPageDialectType defaultDialectType = DBPageDialectType.MYSQL; // 数据库类型(默认为mysql)
	private static DBPageDialectType dialectType; // 数据库类型(默认为mysql)

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);
		// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);
		}

		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
		String dialect = configuration.getVariables().getProperty("dialect");
		if (null == dialect || "".equals(dialect)) {
			logger.warn("Property dialect is not setted,use default 'mysql' ");
			dialectType = defaultDialectType;
		} else {
			dialectType = DBPageDialectType.fromCode(dialect);

			if (dialectType == null) {
				logger.warn("Unsupported dialect: {}", dialect);
				throw new IllegalArgumentException("Unsupported dialect: " + dialect);
			}
		}

		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		Object parameterObject = boundSql.getParameterObject();

		// 只重写需要分页的sql语句(存在分页参数page)
		if (parameterObject != null && metaStatementHandler.hasGetter("delegate.boundSql.parameterObject.page")) {
			Page<?> page = (Page<?>) metaStatementHandler.getValue("delegate.boundSql.parameterObject.page");

			String sql = boundSql.getSql();
			// 重写sql
			String pageSql = buildPageSql(sql, page);

			metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);

			// 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
			Connection connection = (Connection) invocation.getArgs()[0];

			// 重设分页参数里的总页数等
			setPageParameter(sql, connection, mappedStatement, boundSql, page);
		}

		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	/**
	 * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数
	 * <code>PageParameter</code>获得相关信息。
	 * 
	 * @param sql
	 * @param connection
	 * @param mappedStatement
	 * @param boundSql
	 * @param page
	 */
	private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
			BoundSql boundSql, Page<?> page) {
		// 记录总记录数
		String countSql = "select count(0) from (" + sql + ") as total";
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
					boundSql.getParameterMappings(), boundSql.getParameterObject());
			setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
			rs = countStmt.executeQuery();
			int totalCount = 0;
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			page.setTotalCount(totalCount);
			int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
			page.setTotalPage(totalPage);

		} catch (SQLException e) {
			logger.error("Ignore this exception", e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
			try {
				countStmt.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
		}

	}

	/**
	 * 对SQL参数(?)设值
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
		parameterHandler.setParameters(ps);
	}

	/**
	 * 根据数据库类型，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String buildPageSql(String sql, Page<?> page) {
		DBPageDialect dbPageDialect = DBPageDialectFactory.getInstance().getDBPageDialect(dialectType);

		return dbPageDialect.getPageQuerySql(sql, (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize());
	}

	@Override
	public Object plugin(Object target) {
		// 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
