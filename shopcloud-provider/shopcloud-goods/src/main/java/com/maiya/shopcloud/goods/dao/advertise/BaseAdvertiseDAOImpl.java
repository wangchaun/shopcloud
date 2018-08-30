/**
 * 
 */
package com.maiya.shopcloud.goods.dao.advertise;

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
 * @create		2018-08-21 13:26:31
 */
public abstract class BaseAdvertiseDAOImpl implements AdvertiseDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="goodMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public String insert(AdvertiseDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseAdvertiseDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseAdvertiseDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<AdvertiseDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseAdvertiseDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseAdvertiseDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(AdvertiseDO eo) {
		int update = mybatisTemplete.update("BaseAdvertiseDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(AdvertiseDO oldObj, AdvertiseDO newObj) {
        Map<String, AdvertiseDO> paramMap = new HashMap<String, AdvertiseDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseAdvertiseDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<AdvertiseDO> eoList) {
		mybatisTemplete.updateBatch("BaseAdvertiseDAO.update", eoList);
	}

	@Override
	public int delete(AdvertiseDO eo) {
		int delete = mybatisTemplete.delete("BaseAdvertiseDAO.delete", eo);
		
		return delete;
	}

	@Override
	public AdvertiseDO select(String id) {
		return select(id,false);
	}
	
	@Override
	public AdvertiseDO selectAndLock(String id) {
		return select(id,true);
	}
	
	public AdvertiseDO select(String id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (AdvertiseDO) mybatisTemplete.queryForObject("BaseAdvertiseDAO.select", paramMap);
	}
	
	
	@Override
	public AdvertiseDO selectByEO(AdvertiseDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (AdvertiseDO) mybatisTemplete.queryForObject("BaseAdvertiseDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(AdvertiseDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseAdvertiseDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdvertiseDO> selectListByEO(AdvertiseDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseAdvertiseDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<AdvertiseDO> selectListByIdList(List<String> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseAdvertiseDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdvertiseDO> selectListByEO(AdvertiseDO eo,int pageNO,int pageSize) {
		Page<AdvertiseDO> page = new Page<AdvertiseDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<AdvertiseDO> queryForPage(AdvertiseDO eo, Page<AdvertiseDO> page){
    	return mybatisTemplete.queryForPage("BaseAdvertiseDAO.selectEOByEO", eo, page);
    }
}
