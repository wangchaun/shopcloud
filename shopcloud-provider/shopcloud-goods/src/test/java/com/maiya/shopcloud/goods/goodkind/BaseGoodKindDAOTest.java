package com.maiya.shopcloud.goods.goodkind;

import static org.junit.Assert.*;

import com.maiya.shopcloud.goods.dao.goodkind.GoodKindDAO;
import com.maiya.shopcloud.goods.dao.goodkind.GoodKindDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import com.maiya.shopcloud.base.mybatis.MybatisBaseDAOImpl;
import com.maiya.shopcloud.base.pagination.Page;
import com.maiya.shopcloud.base.utils.DateTimeUtils;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 访问接口单元测试类
 * @author		byu.peng
 * @create		2018-08-19 14:52:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public  class BaseGoodKindDAOTest{
	/**
	 * 系统日志输出句柄
	 */
	protected final Logger logger = LoggerFactory.getLogger(BaseGoodKindDAOTest.class);

	/**
	 * 访问接口
	 */
    @Autowired
	protected GoodKindDAO dao;

    protected String id;

    @Before
    public void setup() {
        testInsert();
    }

    @After
    public void clear() {
        //测试删除操作
        testDelete();
    }

	/**
	 * 测试插入操作
	 * @return
	 */
	@Test
	public void testInsert() {
		// 构造对象
		GoodKindDO insertAflEO = new GoodKindDO();

		insertAflEO.setId(insertId);
		insertAflEO.setCode(insertCode);
		insertAflEO.setName(insertName);
		insertAflEO.setGoodTypeId(insertGoodTypeId);
		insertAflEO.setGoodTypeName(insertGoodTypeName);
		insertAflEO.setSort(insertSort);
		insertAflEO.setRemark(insertRemark);
		insertAflEO.setCreatorId(insertCreatorId);
		insertAflEO.setCreatorName(insertCreatorName);
		insertAflEO.setCreateTime(insertCreateTime);
		insertAflEO.setModifierId(insertModifierId);
		insertAflEO.setModifierName(insertModifierName);
		insertAflEO.setModifyTime(insertModifyTime);
		insertAflEO.setState(insertState);
		
		//执行插入
        id = dao.insert(insertAflEO);
		assertNotNull(id);
	}

	/**
	 * 测试查询操作
	 * @param id
	 * @param selectEO
	 * @return 
	 */
    @Test
	public void testSelect() {
		//执行查询
		GoodKindDO selectEO = dao.select(id);
		
		//判断查询出的数据是否正确
		assertEquals(id,selectEO.getId());
		assertEquals(insertCode,selectEO.getCode().trim());
		assertEquals(insertName,selectEO.getName().trim());
		assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
		assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
		assertEquals(insertSort,selectEO.getSort());
		assertEquals(insertRemark,selectEO.getRemark().trim());
		assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
		assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
		assertEquals(insertCreateTime,selectEO.getCreateTime());
		assertEquals(insertModifierId,selectEO.getModifierId().trim());
		assertEquals(insertModifierName,selectEO.getModifierName().trim());
		assertEquals(insertModifyTime,selectEO.getModifyTime());
		assertEquals(insertState,selectEO.getState().trim());
	}

    /**
     * 测试根据对象查询操作
     * @param selectEO
     * @return
     */
    @Test
    public void testSelectByEO() {
        GoodKindDO eo = dao.select(id);
        GoodKindDO selectEO = dao.selectByEO(eo);

        assertEquals(id,selectEO.getId());
        assertEquals(insertCode,selectEO.getCode().trim());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
        assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
        assertEquals(insertSort,selectEO.getSort());
        assertEquals(insertRemark,selectEO.getRemark().trim());
        assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
        assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
        assertEquals(insertCreateTime,selectEO.getCreateTime());
        assertEquals(insertModifierId,selectEO.getModifierId().trim());
        assertEquals(insertModifierName,selectEO.getModifierName().trim());
        assertEquals(insertModifyTime,selectEO.getModifyTime());
        assertEquals(insertState,selectEO.getState().trim());
    }

    /**
     * 测试根据对象查询List操作
     * @param selectEO
     * @return
     */
    @Test
    public void testSelectListByEO() {
        GoodKindDO eo = dao.select(id);
        List<GoodKindDO> resultList = dao.selectListByEO(eo);

        assertEquals(1, resultList.size());
        GoodKindDO selectEO = resultList.get(0);

            assertEquals(id,selectEO.getId());
        assertEquals(insertCode,selectEO.getCode().trim());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
        assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
        assertEquals(insertSort,selectEO.getSort());
        assertEquals(insertRemark,selectEO.getRemark().trim());
        assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
        assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
        assertEquals(insertCreateTime,selectEO.getCreateTime());
        assertEquals(insertModifierId,selectEO.getModifierId().trim());
        assertEquals(insertModifierName,selectEO.getModifierName().trim());
        assertEquals(insertModifyTime,selectEO.getModifyTime());
        assertEquals(insertState,selectEO.getState().trim());
    }

    /**
     * 测试根据对象分页查询操作
     * @param selectEO
     * @return
    */
    @Test
    public void testQueryForPage() {
        GoodKindDO eo = dao.select(id);
        Page<GoodKindDO> page = new Page<GoodKindDO>();
        page.setPageNo(1);
        page.setPageSize(10);
        Page<GoodKindDO> resultPage = dao.queryForPage(eo, page);

        assertEquals(1, resultPage.getTotalCount());
        GoodKindDO selectEO = resultPage.getResult().get(0);

        assertEquals(id,selectEO.getId());
        assertEquals(insertCode,selectEO.getCode().trim());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
        assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
        assertEquals(insertSort,selectEO.getSort());
        assertEquals(insertRemark,selectEO.getRemark().trim());
        assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
        assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
        assertEquals(insertCreateTime,selectEO.getCreateTime());
        assertEquals(insertModifierId,selectEO.getModifierId().trim());
        assertEquals(insertModifierName,selectEO.getModifierName().trim());
        assertEquals(insertModifyTime,selectEO.getModifyTime());
        assertEquals(insertState,selectEO.getState().trim());
        }

	/**
	 * 测试更新操作
	 * @param id 被更新记录的主键
	 * @param selectEO 被更新的EO对象
	 */
    @Test
    public void testUpdate() {
        GoodKindDO selectEO = dao.select(id);

		// 更改各个字段的值
		selectEO.setCode(updateCode);
		selectEO.setName(updateName);
		selectEO.setGoodTypeId(updateGoodTypeId);
		selectEO.setGoodTypeName(updateGoodTypeName);
		selectEO.setSort(updateSort);
		selectEO.setRemark(updateRemark);
		selectEO.setCreatorId(updateCreatorId);
		selectEO.setCreatorName(updateCreatorName);
		selectEO.setCreateTime(updateCreateTime);
		selectEO.setModifierId(updateModifierId);
		selectEO.setModifierName(updateModifierName);
		selectEO.setModifyTime(updateModifyTime);
		selectEO.setState(updateState);
		
		//执行更新操作
		int updateCount = dao.update(selectEO);
		assertEquals(1,updateCount);

        }
	
	/**
	 * 测试更新操作
	 * @param id 被更新记录的主键
	 * @param selectEO 被更新的EO对象
	 */
    @Test
    public void testUpdateField() {
        GoodKindDO selectEO = dao.select(id);

		// 更改各个字段的值
		selectEO.setCode(updateFieldCode);
		selectEO.setName(updateFieldName);
		selectEO.setGoodTypeId(updateFieldGoodTypeId);
		selectEO.setGoodTypeName(updateFieldGoodTypeName);
		selectEO.setSort(updateFieldSort);
		selectEO.setRemark(updateFieldRemark);
		selectEO.setCreatorId(updateFieldCreatorId);
		selectEO.setCreatorName(updateFieldCreatorName);
		selectEO.setCreateTime(updateFieldCreateTime);
		selectEO.setModifierId(updateFieldModifierId);
		selectEO.setModifierName(updateFieldModifierName);
		selectEO.setModifyTime(updateFieldModifyTime);
		selectEO.setState(updateFieldState);

        GoodKindDO old = new GoodKindDO();
        old.setId(id);
	
		//执行更新操作
		int updateCount = dao.updateByField(old, selectEO);
		assertEquals(1,updateCount);
	}

	/**
	 * 测试删除操作
	 * @param id 被删除记录的主键
	 * @param selectEO 被删除的EO对象
	 */
	private void testDelete() {
        // 构造对象
        GoodKindDO selectEO = new GoodKindDO();
        selectEO.setId(id);

		// 执行删除操作
		dao.delete(selectEO);

        GoodKindDO result = dao.select(id);

		assertNull(result);
	}


    //////////////////////////insert的初始数据//////////////////////////////////////////////////

    /**
     * 类别id
     */
    private String insertId = "20180819145252002751";

    /**
     * 
     */
    private String insertCode = "1";

    /**
     * 
     */
    private String insertName = "1";

    /**
     * 
     */
    private String insertGoodTypeId = "1";

    /**
     * 
     */
    private String insertGoodTypeName = "1";

    /**
     * 序号
     */
    private Integer insertSort = new Integer("1");

    /**
     * 备注
     */
    private String insertRemark = "1";

    /**
     * 创建人id
     */
    private String insertCreatorId = "1";

    /**
     * 创建人姓名
     */
    private String insertCreatorName = "1";

    /**
     * 创建时间
     */
    private Date insertCreateTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 修改人id
     */
    private String insertModifierId = "1";

    /**
     * 修改人姓名
     */
    private String insertModifierName = "1";

    /**
     * 修改时间
     */
    private Date insertModifyTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 数据状态 c:草稿 s;审核 d:删除
     */
    private String insertState = "1";


    ////////////////////////////update的初始数据/////////////////////////////////////////////////

    /**
     * 
     */
    private String updateCode = "2";

    /**
     * 
     */
    private String updateName = "2";

    /**
     * 
     */
    private String updateGoodTypeId = "2";

    /**
     * 
     */
    private String updateGoodTypeName = "2";

    /**
     * 序号
     */
    private Integer updateSort = new Integer("2");

    /**
     * 备注
     */
    private String updateRemark = "2";

    /**
     * 创建人id
     */
    private String updateCreatorId = "2";

    /**
     * 创建人姓名
     */
    private String updateCreatorName = "2";

    /**
     * 创建时间
     */
    private Date updateCreateTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 修改人id
     */
    private String updateModifierId = "2";

    /**
     * 修改人姓名
     */
    private String updateModifierName = "2";

    /**
     * 修改时间
     */
    private Date updateModifyTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 数据状态 c:草稿 s;审核 d:删除
     */
    private String updateState = "2";


////////////////////////////update field的初始数据/////////////////////////////////////////////////

    /**
     * 
     */
    private String updateFieldCode = "3";

    /**
     * 
     */
    private String updateFieldName = "3";

    /**
     * 
     */
    private String updateFieldGoodTypeId = "3";

    /**
     * 
     */
    private String updateFieldGoodTypeName = "3";

    /**
     * 序号
     */
    private Integer updateFieldSort = new Integer("3");

    /**
     * 备注
     */
    private String updateFieldRemark = "3";

    /**
     * 创建人id
     */
    private String updateFieldCreatorId = "3";

    /**
     * 创建人姓名
     */
    private String updateFieldCreatorName = "3";

    /**
     * 创建时间
     */
    private Date updateFieldCreateTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 修改人id
     */
    private String updateFieldModifierId = "3";

    /**
     * 修改人姓名
     */
    private String updateFieldModifierName = "3";

    /**
     * 修改时间
     */
    private Date updateFieldModifyTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 数据状态 c:草稿 s;审核 d:删除
     */
    private String updateFieldState = "3";

}
