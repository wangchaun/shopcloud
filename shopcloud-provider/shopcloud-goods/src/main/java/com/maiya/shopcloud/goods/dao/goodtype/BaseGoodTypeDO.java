package com.maiya.shopcloud.goods.dao.goodtype;

import java.math.BigDecimal;
import java.util.Date;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 商品类别实体对象
 * @author		byu.peng
 * @create		2018-08-21 01:05:29
 */
public abstract class BaseGoodTypeDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 类别id
	 */
	protected String id;

	/**
	 * 父亲id,0:根节点
	 */
	protected String parentId;

	/**
	 * 类别编码
	 */
	protected String code;

	/**
	 * 类别名称
	 */
	protected String name;

	/**
	 * 层级 1:一级 2:二级  3:三级
	 */
	protected Integer level;

	/**
	 * 备注
	 */
	protected String remark;

	/**
	 * 序号
	 */
	protected Integer sort;

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
	 * 
	 */
	protected String picId;

	/**
	 * 
	 */
	protected String pic;

	/**
	 * 
	 */
	protected String isInventory;

	/**
	 * 
	 */
	protected String listshow;

	/**
	 * 
	 */
	protected String paymentId;

	/**
	 * 
	 */
	protected String paymentName;

	/**
	 * 
	 */
	protected String deliveryId;

	/**
	 * 
	 */
	protected String isparent;

	/**
	 * 
	 */
	protected String deliveryName;

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
	 * 取得 父亲id,0:根节点
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 设置 父亲id,0:根节点
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 取得 类别编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置 类别编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 取得 类别名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得 层级 1:一级 2:二级  3:三级
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 设置 层级 1:一级 2:二级  3:三级
	 */
	public void setLevel(Integer level) {
		this.level = level;
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

	/**
	 * 取得 
	 */
	public String getPicId() {
		return picId;
	}

	/**
	 * 设置 
	 */
	public void setPicId(String picId) {
		this.picId = picId;
	}

	/**
	 * 取得 
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * 设置 
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * 取得 
	 */
	public String getIsInventory() {
		return isInventory;
	}

	/**
	 * 设置 
	 */
	public void setIsInventory(String isInventory) {
		this.isInventory = isInventory;
	}

	/**
	 * 取得 
	 */
	public String getListshow() {
		return listshow;
	}

	/**
	 * 设置 
	 */
	public void setListshow(String listshow) {
		this.listshow = listshow;
	}

	/**
	 * 取得 
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * 设置 
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * 取得 
	 */
	public String getPaymentName() {
		return paymentName;
	}

	/**
	 * 设置 
	 */
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	/**
	 * 取得 
	 */
	public String getDeliveryId() {
		return deliveryId;
	}

	/**
	 * 设置 
	 */
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	/**
	 * 取得 
	 */
	public String getIsparent() {
		return isparent;
	}

	/**
	 * 设置 
	 */
	public void setIsparent(String isparent) {
		this.isparent = isparent;
	}

	/**
	 * 取得 
	 */
	public String getDeliveryName() {
		return deliveryName;
	}

	/**
	 * 设置 
	 */
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}