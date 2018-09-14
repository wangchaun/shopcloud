/**
 * 
 */
package com.maiya.shopcloud.account.dao.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.maiya.shopcloud.base.mybatis.MybatisBaseDAOImpl;
import com.maiya.shopcloud.base.pagination.Page;

/**
 * 访问接口抽象实现
 * @author		siming.wang
 * @create		2018-09-14 13:50:57
 */
public abstract class BaseCustomerDAOImpl implements CustomerDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="accountMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public String insert(CustomerDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseCustomerDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseCustomerDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<CustomerDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseCustomerDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseCustomerDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(CustomerDO eo) {
		int update = mybatisTemplete.update("BaseCustomerDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(CustomerDO oldObj, CustomerDO newObj) {
        Map<String, CustomerDO> paramMap = new HashMap<String, CustomerDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseCustomerDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<CustomerDO> eoList) {
		mybatisTemplete.updateBatch("BaseCustomerDAO.update", eoList);
	}

	@Override
	public int delete(CustomerDO eo) {
		int delete = mybatisTemplete.delete("BaseCustomerDAO.delete", eo);
		
		return delete;
	}

	@Override
	public CustomerDO select(String id) {
		return select(id,false);
	}
	
	@Override
	public CustomerDO selectAndLock(String id) {
		return select(id,true);
	}
	
	public CustomerDO select(String id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (CustomerDO) mybatisTemplete.queryForObject("BaseCustomerDAO.select", paramMap);
	}
	
	
	@Override
	public CustomerDO selectByEO(CustomerDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (CustomerDO) mybatisTemplete.queryForObject("BaseCustomerDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(CustomerDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseCustomerDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerDO> selectListByEO(CustomerDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseCustomerDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerDO> selectListByIdList(List<String> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseCustomerDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerDO> selectListByEO(CustomerDO eo,int pageNO,int pageSize) {
		Page<CustomerDO> page = new Page<CustomerDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<CustomerDO> queryForPage(CustomerDO eo, Page<CustomerDO> page){
    	return mybatisTemplete.queryForPage("BaseCustomerDAO.selectEOByEO", eo, page);
    }
}
