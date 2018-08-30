package com.maiya.shopcloud.goods.dao.goodkind;

import java.math.BigDecimal;
import java.util.Date;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 实体对象
 * @author		byu.peng
 * @create		2018-08-21 01:05:29
 */
public abstract class BaseGoodKindDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 类别id
	 */
	protected String id;

	/**
	 * 
	 */
	protected String code;

	/**
	 * 
	 */
	protected String name;

	/**
	 * 
	 */
	protected String goodTypeId;

	/**
	 * 
	 */
	protected String goodTypeName;

	/**
	 * 序号
	 */
	protected Integer sort;

	/**
	 * 备注
	 */
	protected String remark;

	/**
	 * 创建人id
	 */
	protected String creatorId;

	/**
	 * 创建人姓名
	 */
	protected String creatorName;

	/**
	 * 创建时间
	 */
	protected Date createTime;

	/**
	 * 修改人id
	 */
	protected String modifierId;

	/**
	 * 修改人姓名
	 */
	protected String modifierName;

	/**
	 * 修改时间
	 */
	protected Date modifyTime;

	/**
	 * 数据状态 c:草稿 s;审核 d:删除
	 */
	protected String state;

	/**
	 * 取得 类别id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 类别id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 取得 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 取得 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得 
	 */
	public String getGoodTypeId() {
		return goodTypeId;
	}

	/**
	 * 设置 
	 */
	public void setGoodTypeId(String goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

	/**
	 * 取得 
	 */
	public String getGoodTypeName() {
		return goodTypeName;
	}

	/**
	 * 设置 
	 */
	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	/**
	 * 取得 序号
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置 序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 取得 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 取得 创建人id
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * 设置 创建人id
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 取得 创建人姓名
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * 设置 创建人姓名
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	/**
	 * 取得 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 取得 修改人id
	 */
	public String getModifierId() {
		return modifierId;
	}

	/**
	 * 设置 修改人id
	 */
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	/**
	 * 取得 修改人姓名
	 */
	public String getModifierName() {
		return modifierName;
	}

	/**
	 * 设置 修改人姓名
	 */
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	/**
	 * 取得 修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置 修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 取得 数据状态 c:草稿 s;审核 d:删除
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置 数据状态 c:草稿 s;审核 d:删除
	 */
	public void setState(String state) {
		this.state = state;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}