package com.maiya.shopcloud.account.dao.customer;

import java.math.BigDecimal;
import java.util.Date;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 实体对象
 * @author		siming.wang
 * @create		2018-09-14 13:50:57
 */
public abstract class BaseCustomerDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 
	 */
	protected String id;

	/**
	 * 0: 普通会员    1:联盟店会员  2:企业会员
	 */
	protected String type;

	/**
	 * 
	 */
	protected String name;

	/**
	 * 
	 */
	protected String cardNumber;

	/**
	 * 
	 */
	protected String code;

	/**
	 * 
	 */
	protected String sex;

	/**
	 * 
	 */
	protected String account;

	/**
	 * 
	 */
	protected String pwd;

	/**
	 * 
	 */
	protected BigDecimal payables;

	/**
	 * 
	 */
	protected String vipLevelId;

	/**
	 * 
	 */
	protected String vipLevelName;

	/**
	 * 
	 */
	protected BigDecimal credits;

	/**
	 * 
	 */
	protected String companyName;

	/**
	 * 
	 */
	protected String companyAddress;

	/**
	 * 
	 */
	protected String linkman;

	/**
	 * 
	 */
	protected String mobile;

	/**
	 * 
	 */
	protected String telephone;

	/**
	 * 
	 */
	protected String email;

	/**
	 * 
	 */
	protected String areaIds;

	/**
	 * 
	 */
	protected String areaNames;

	/**
	 * 
	 */
	protected String street;

	/**
	 * 
	 */
	protected String zipCode;

	/**
	 * 
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
	 * 
	 */
	protected String warehouseId;

	/**
	 * 
	 */
	protected String warehouseName;

	/**
	 * 婚姻状况
	 */
	protected String maritalstatus;

	/**
	 * 受教育程度
	 */
	protected String schooling;

	/**
	 * 月收入
	 */
	protected String salary;

	/**
	 * 是否绑定手机  0未绑定   1已绑定
	 */
	protected String isPinlessmobile;

	/**
	 * 是否绑定邮箱   0为绑定  1已绑定
	 */
	protected String isPinlessemail;

	/**
	 * 
	 */
	protected String pic;

	/**
	 * 
	 */
	protected String picId;

	/**
	 * 
	 */
	protected String idCard;

	/**
	 * 
	 */
	protected Date cardEndtime;

	/**
	 * 
	 */
	protected String cardAddress;

	/**
	 * 
	 */
	protected String innerPicid;

	/**
	 * 
	 */
	protected String innerPic;

	/**
	 * 
	 */
	protected String innerName;

	/**
	 * 
	 */
	protected String innerArea;

	/**
	 * 
	 */
	protected String innerIntroduce;

	/**
	 * 
	 */
	protected String agree;

	/**
	 * 
	 */
	protected Integer credit;

	/**
	 * 
	 */
	protected String clintip;

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
	 * 取得 0: 普通会员    1:联盟店会员  2:企业会员
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置 0: 普通会员    1:联盟店会员  2:企业会员
	 */
	public void setType(String type) {
		this.type = type;
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
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * 设置 
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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
	public String getSex() {
		return sex;
	}

	/**
	 * 设置 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 取得 
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置 
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 取得 
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * 设置 
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getPayables() {
		return payables;
	}

	/**
	 * 设置 
	 */
	public void setPayables(BigDecimal payables) {
		this.payables = payables;
	}

	/**
	 * 取得 
	 */
	public String getVipLevelId() {
		return vipLevelId;
	}

	/**
	 * 设置 
	 */
	public void setVipLevelId(String vipLevelId) {
		this.vipLevelId = vipLevelId;
	}

	/**
	 * 取得 
	 */
	public String getVipLevelName() {
		return vipLevelName;
	}

	/**
	 * 设置 
	 */
	public void setVipLevelName(String vipLevelName) {
		this.vipLevelName = vipLevelName;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getCredits() {
		return credits;
	}

	/**
	 * 设置 
	 */
	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	/**
	 * 取得 
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置 
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 取得 
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * 设置 
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 取得 
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * 设置 
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
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
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置 
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 取得 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 取得 
	 */
	public String getAreaIds() {
		return areaIds;
	}

	/**
	 * 设置 
	 */
	public void setAreaIds(String areaIds) {
		this.areaIds = areaIds;
	}

	/**
	 * 取得 
	 */
	public String getAreaNames() {
		return areaNames;
	}

	/**
	 * 设置 
	 */
	public void setAreaNames(String areaNames) {
		this.areaNames = areaNames;
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
	public String getWarehouseId() {
		return warehouseId;
	}

	/**
	 * 设置 
	 */
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * 取得 
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * 设置 
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * 取得 婚姻状况
	 */
	public String getMaritalstatus() {
		return maritalstatus;
	}

	/**
	 * 设置 婚姻状况
	 */
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	/**
	 * 取得 受教育程度
	 */
	public String getSchooling() {
		return schooling;
	}

	/**
	 * 设置 受教育程度
	 */
	public void setSchooling(String schooling) {
		this.schooling = schooling;
	}

	/**
	 * 取得 月收入
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * 设置 月收入
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * 取得 是否绑定手机  0未绑定   1已绑定
	 */
	public String getIsPinlessmobile() {
		return isPinlessmobile;
	}

	/**
	 * 设置 是否绑定手机  0未绑定   1已绑定
	 */
	public void setIsPinlessmobile(String isPinlessmobile) {
		this.isPinlessmobile = isPinlessmobile;
	}

	/**
	 * 取得 是否绑定邮箱   0为绑定  1已绑定
	 */
	public String getIsPinlessemail() {
		return isPinlessemail;
	}

	/**
	 * 设置 是否绑定邮箱   0为绑定  1已绑定
	 */
	public void setIsPinlessemail(String isPinlessemail) {
		this.isPinlessemail = isPinlessemail;
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
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置 
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 取得 
	 */
	public Date getCardEndtime() {
		return cardEndtime;
	}

	/**
	 * 设置 
	 */
	public void setCardEndtime(Date cardEndtime) {
		this.cardEndtime = cardEndtime;
	}

	/**
	 * 取得 
	 */
	public String getCardAddress() {
		return cardAddress;
	}

	/**
	 * 设置 
	 */
	public void setCardAddress(String cardAddress) {
		this.cardAddress = cardAddress;
	}

	/**
	 * 取得 
	 */
	public String getInnerPicid() {
		return innerPicid;
	}

	/**
	 * 设置 
	 */
	public void setInnerPicid(String innerPicid) {
		this.innerPicid = innerPicid;
	}

	/**
	 * 取得 
	 */
	public String getInnerPic() {
		return innerPic;
	}

	/**
	 * 设置 
	 */
	public void setInnerPic(String innerPic) {
		this.innerPic = innerPic;
	}

	/**
	 * 取得 
	 */
	public String getInnerName() {
		return innerName;
	}

	/**
	 * 设置 
	 */
	public void setInnerName(String innerName) {
		this.innerName = innerName;
	}

	/**
	 * 取得 
	 */
	public String getInnerArea() {
		return innerArea;
	}

	/**
	 * 设置 
	 */
	public void setInnerArea(String innerArea) {
		this.innerArea = innerArea;
	}

	/**
	 * 取得 
	 */
	public String getInnerIntroduce() {
		return innerIntroduce;
	}

	/**
	 * 设置 
	 */
	public void setInnerIntroduce(String innerIntroduce) {
		this.innerIntroduce = innerIntroduce;
	}

	/**
	 * 取得 
	 */
	public String getAgree() {
		return agree;
	}

	/**
	 * 设置 
	 */
	public void setAgree(String agree) {
		this.agree = agree;
	}

	/**
	 * 取得 
	 */
	public Integer getCredit() {
		return credit;
	}

	/**
	 * 设置 
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	/**
	 * 取得 
	 */
	public String getClintip() {
		return clintip;
	}

	/**
	 * 设置 
	 */
	public void setClintip(String clintip) {
		this.clintip = clintip;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}