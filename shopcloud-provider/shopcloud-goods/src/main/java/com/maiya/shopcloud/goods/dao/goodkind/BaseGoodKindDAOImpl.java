/**
 * 
 */
package com.maiya.shopcloud.goods.dao.goodkind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.maiya.shopcloud.base.mybatis.MybatisBaseDAOImpl;
import com.maiya.shopcloud.base.pagination.Page;

/**
 * 访问接口抽象实现
 * @author		byu.peng
 * @create		2018-08-21 01:05:29
 */
public abstract class BaseGoodKindDAOImpl implements GoodKindDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="goodMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public String insert(GoodKindDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseGoodKindDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseGoodKindDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<GoodKindDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseGoodKindDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseGoodKindDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(GoodKindDO eo) {
		int update = mybatisTemplete.update("BaseGoodKindDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(GoodKindDO oldObj, GoodKindDO newObj) {
        Map<String, GoodKindDO> paramMap = new HashMap<String, GoodKindDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseGoodKindDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<GoodKindDO> eoList) {
		mybatisTemplete.updateBatch("BaseGoodKindDAO.update", eoList);
	}

	@Override
	public int delete(GoodKindDO eo) {
		int delete = mybatisTemplete.delete("BaseGoodKindDAO.delete", eo);
		
		return delete;
	}

	@Override
	public GoodKindDO select(String id) {
		return select(id,false);
	}
	
	@Override
	public GoodKindDO selectAndLock(String id) {
		return select(id,true);
	}
	
	public GoodKindDO select(String id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (GoodKindDO) mybatisTemplete.queryForObject("BaseGoodKindDAO.select", paramMap);
	}
	
	
	@Override
	public GoodKindDO selectByEO(GoodKindDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (GoodKindDO) mybatisTemplete.queryForObject("BaseGoodKindDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(GoodKindDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseGoodKindDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodKindDO> selectListByEO(GoodKindDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseGoodKindDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<GoodKindDO> selectListByIdList(List<String> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseGoodKindDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodKindDO> selectListByEO(GoodKindDO eo,int pageNO,int pageSize) {
		Page<GoodKindDO> page = new Page<GoodKindDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<GoodKindDO> queryForPage(GoodKindDO eo, Page<GoodKindDO> page){
    	return mybatisTemplete.queryForPage("BaseGoodKindDAO.selectEOByEO", eo, page);
    }
}
