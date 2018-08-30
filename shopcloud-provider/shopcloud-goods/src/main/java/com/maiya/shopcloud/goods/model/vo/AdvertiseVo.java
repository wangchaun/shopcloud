package com.maiya.shopcloud.goods.model.vo;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

/**
 * 实体对象
 * @author		byu.peng
 * @create		2018-08-21 13:26:31
 */
public  class AdvertiseVo  implements java.io.Serializable {

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsGoodTypeId() {
		return isGoodTypeId;
	}

	public void setIsGoodTypeId(String isGoodTypeId) {
		this.isGoodTypeId = isGoodTypeId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}