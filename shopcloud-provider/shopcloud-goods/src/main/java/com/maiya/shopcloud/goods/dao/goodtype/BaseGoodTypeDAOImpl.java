/**
 * 
 */
package com.maiya.shopcloud.goods.dao.goodtype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.maiya.shopcloud.base.mybatis.MybatisBaseDAOImpl;
import com.maiya.shopcloud.base.pagination.Page;

/**
 * 商品类别访问接口抽象实现
 * @author		byu.peng
 * @create		2018-08-21 01:05:29
 */
public abstract class BaseGoodTypeDAOImpl implements GoodTypeDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="goodMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public String insert(GoodTypeDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseGoodTypeDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseGoodTypeDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<GoodTypeDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseGoodTypeDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseGoodTypeDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(GoodTypeDO eo) {
		int update = mybatisTemplete.update("BaseGoodTypeDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(GoodTypeDO oldObj, GoodTypeDO newObj) {
        Map<String, GoodTypeDO> paramMap = new HashMap<String, GoodTypeDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseGoodTypeDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<GoodTypeDO> eoList) {
		mybatisTemplete.updateBatch("BaseGoodTypeDAO.update", eoList);
	}

	@Override
	public int delete(GoodTypeDO eo) {
		int delete = mybatisTemplete.delete("BaseGoodTypeDAO.delete", eo);
		
		return delete;
	}

	@Override
	public GoodTypeDO select(String id) {
		return select(id,false);
	}
	
	@Override
	public GoodTypeDO selectAndLock(String id) {
		return select(id,true);
	}
	
	public GoodTypeDO select(String id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (GoodTypeDO) mybatisTemplete.queryForObject("BaseGoodTypeDAO.select", paramMap);
	}
	
	
	@Override
	public GoodTypeDO selectByEO(GoodTypeDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (GoodTypeDO) mybatisTemplete.queryForObject("BaseGoodTypeDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(GoodTypeDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseGoodTypeDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodTypeDO> selectListByEO(GoodTypeDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseGoodTypeDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<GoodTypeDO> selectListByIdList(List<String> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseGoodTypeDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodTypeDO> selectListByEO(GoodTypeDO eo,int pageNO,int pageSize) {
		Page<GoodTypeDO> page = new Page<GoodTypeDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<GoodTypeDO> queryForPage(GoodTypeDO eo, Page<GoodTypeDO> page){
    	return mybatisTemplete.queryForPage("BaseGoodTypeDAO.selectEOByEO", eo, page);
    }
}
