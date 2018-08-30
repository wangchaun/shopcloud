/**
 * 
 */
package com.maiya.shopcloud.goods.dao.good;

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
public abstract class BaseGoodDAOImpl implements GoodDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="goodMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public String insert(GoodDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseGoodDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseGoodDAO.insert", eo);
		}

            eo.setVersion(1);

        return eo.getId();
	}

	@Override
	public void batchInsert(List<GoodDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseGoodDAO.batchInsert", eoList);
			
			for(GoodDO eo : eoList) {
				eo.setVersion(1);
			}
		}else{
			mybatisTemplete.insert("BaseGoodDAO.batchInsertHasId", eoList);
			
			for(GoodDO eo : eoList) {
				eo.setVersion(1);
			}
		}
	}

	@Override
	public int update(GoodDO eo) {
		int update = mybatisTemplete.update("BaseGoodDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		eo.setVersion(eo.getVersion()+1);
		
		return update;
	}
	
	@Override
	public int updateByField(GoodDO oldObj, GoodDO newObj) {
        Map<String, GoodDO> paramMap = new HashMap<String, GoodDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseGoodDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<GoodDO> eoList) {
		mybatisTemplete.updateBatch("BaseGoodDAO.update", eoList);
	}

	@Override
	public int delete(GoodDO eo) {
		int delete = mybatisTemplete.delete("BaseGoodDAO.delete", eo);
		
		return delete;
	}

	@Override
	public GoodDO select(String id) {
		return select(id,false);
	}
	
	@Override
	public GoodDO selectAndLock(String id) {
		return select(id,true);
	}
	
	public GoodDO select(String id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (GoodDO) mybatisTemplete.queryForObject("BaseGoodDAO.select", paramMap);
	}
	
	
	@Override
	public GoodDO selectByEO(GoodDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (GoodDO) mybatisTemplete.queryForObject("BaseGoodDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(GoodDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseGoodDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodDO> selectListByEO(GoodDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseGoodDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<GoodDO> selectListByIdList(List<String> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseGoodDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodDO> selectListByEO(GoodDO eo,int pageNO,int pageSize) {
		Page<GoodDO> page = new Page<GoodDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<GoodDO> queryForPage(GoodDO eo, Page<GoodDO> page){
    	return mybatisTemplete.queryForPage("BaseGoodDAO.selectEOByEO", eo, page);
    }
}
