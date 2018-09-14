/**
 * 
 */
package com.maiya.shopcloud.account.dao.customeraddress;

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
public abstract class BaseCustomerAddressDAOImpl implements CustomerAddressDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="accountMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public String insert(CustomerAddressDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseCustomerAddressDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseCustomerAddressDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<CustomerAddressDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseCustomerAddressDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseCustomerAddressDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(CustomerAddressDO eo) {
		int update = mybatisTemplete.update("BaseCustomerAddressDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(CustomerAddressDO oldObj, CustomerAddressDO newObj) {
        Map<String, CustomerAddressDO> paramMap = new HashMap<String, CustomerAddressDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseCustomerAddressDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<CustomerAddressDO> eoList) {
		mybatisTemplete.updateBatch("BaseCustomerAddressDAO.update", eoList);
	}

	@Override
	public int delete(CustomerAddressDO eo) {
		int delete = mybatisTemplete.delete("BaseCustomerAddressDAO.delete", eo);
		
		return delete;
	}

	@Override
	public CustomerAddressDO select(String id) {
		return select(id,false);
	}
	
	@Override
	public CustomerAddressDO selectAndLock(String id) {
		return select(id,true);
	}
	
	public CustomerAddressDO select(String id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (CustomerAddressDO) mybatisTemplete.queryForObject("BaseCustomerAddressDAO.select", paramMap);
	}
	
	
	@Override
	public CustomerAddressDO selectByEO(CustomerAddressDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (CustomerAddressDO) mybatisTemplete.queryForObject("BaseCustomerAddressDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(CustomerAddressDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseCustomerAddressDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerAddressDO> selectListByEO(CustomerAddressDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseCustomerAddressDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerAddressDO> selectListByIdList(List<String> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseCustomerAddressDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerAddressDO> selectListByEO(CustomerAddressDO eo,int pageNO,int pageSize) {
		Page<CustomerAddressDO> page = new Page<CustomerAddressDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<CustomerAddressDO> queryForPage(CustomerAddressDO eo, Page<CustomerAddressDO> page){
    	return mybatisTemplete.queryForPage("BaseCustomerAddressDAO.selectEOByEO", eo, page);
    }
}
