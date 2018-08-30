/**
 * 
 */
package com.maiya.shopcloud.base.base;


import com.maiya.shopcloud.base.pagination.Page;

/**
 * 功能描述：	
 * @author	noaman
 */
public interface BaseDAO2<EntityEO, PK> extends BaseDAO<EntityEO, PK> {
    /**
     * 根据条件分页查询实体对象
     * @param parameterObject	查询参数
     * @param page	分页参数
     * @return
     */
    public Page<EntityEO> queryForPage(EntityEO eo, Page<EntityEO> page);
}
