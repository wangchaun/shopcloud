package com.maiya.shopcloud.goods.dao.advertise;

import java.math.BigDecimal;
import java.util.Date;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 实体对象
 * @author		byu.peng
 * @create		2018-08-21 13:26:31
 */
public abstract class BaseAdvertiseDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 广告id
	 */
	protected String id;

	/**
	 * 
	 */
	protected String code;

	/**
	 * 
	 */
	protected String subject;

	/**
	 * 
	 */
	protected String content;

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
	protected Integer level;

	/**
	 * 
	 */
	protected String placeId;

	/**
	 * 
	 */
	protected String place;

	/**
	 * 
	 */
	protected String type;

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
	 * 链接地址
	 */
	protected String url;

	/**
	 * 是否关联商品类型【父类频道页面广告位】
	 */
	protected String isGoodTypeId;

	/**
	 * 
	 */
	protected String areaId;

	/**
	 * 
	 */
	protected String areaName;

	/**
	 * 取得 广告id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 广告id
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
	public String getSubject() {
		return subject;
	}

	/**
	 * 设置 
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 取得 
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置 
	 */
	public void setContent(String content) {
		this.content = content;
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
	public Integer getLevel() {
		return level;
	}

	/**
	 * 设置 
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * 取得 
	 */
	public String getPlaceId() {
		return placeId;
	}

	/**
	 * 设置 
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * 取得 
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * 设置 
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * 取得 
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置 
	 */
	public void setType(String type) {
		this.type = type;
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
	 * 取得 链接地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置 链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 取得 是否关联商品类型【父类频道页面广告位】
	 */
	public String getIsGoodTypeId() {
		return isGoodTypeId;
	}

	/**
	 * 设置 是否关联商品类型【父类频道页面广告位】
	 */
	public void setIsGoodTypeId(String isGoodTypeId) {
		this.isGoodTypeId = isGoodTypeId;
	}

	/**
	 * 取得 
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * 设置 
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 取得 
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置 
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}