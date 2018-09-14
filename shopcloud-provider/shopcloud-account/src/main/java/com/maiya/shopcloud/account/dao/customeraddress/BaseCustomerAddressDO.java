package com.maiya.shopcloud.account.dao.customeraddress;

import java.math.BigDecimal;
import java.util.Date;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 实体对象
 * @author		siming.wang
 * @create		2018-09-14 13:50:57
 */
public abstract class BaseCustomerAddressDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 
	 */
	protected String id;

	/**
	 * 
	 */
	protected String customerId;

	/**
	 * 
	 */
	protected String name;

	/**
	 * 
	 */
	protected String mobile;

	/**
	 * 
	 */
	protected String address;

	/**
	 * 
	 */
	protected String zipCode;

	/**
	 * 是否是默认地址
	 */
	protected String isDefault;

	/**
	 * 
	 */
	protected String remark;

	/**
	 * 
	 */
	protected String street;

	/**
	 * 
	 */
	protected String arearegion;

	/**
	 * 
	 */
	protected String phone;

	/**
	 * 
	 */
	protected String whetherOrdrer;

	/**
	 * 取得 
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 取得 
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * 设置 
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 取得 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 取得 
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * 设置 
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * 取得 是否是默认地址
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * 设置 是否是默认地址
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * 取得 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 取得 
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 设置 
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 取得 
	 */
	public String getArearegion() {
		return arearegion;
	}

	/**
	 * 设置 
	 */
	public void setArearegion(String arearegion) {
		this.arearegion = arearegion;
	}

	/**
	 * 取得 
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 取得 
	 */
	public String getWhetherOrdrer() {
		return whetherOrdrer;
	}

	/**
	 * 设置 
	 */
	public void setWhetherOrdrer(String whetherOrdrer) {
		this.whetherOrdrer = whetherOrdrer;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}