package com.maiya.shopcloud.goods.dao.good;

import java.math.BigDecimal;
import java.util.Date;

import com.maiya.shopcloud.base.base.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 实体对象
 * @author		byu.peng
 * @create		2018-08-21 01:05:28
 */
public abstract class BaseGoodDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 商品id
	 */
	protected String id;

	/**
	 * 商品编码
	 */
	protected String code;

	/**
	 * 品名
	 */
	protected String name;

	/**
	 * 商品类别编码
	 */
	protected String goodTypeId;

	/**
	 * 商品类别名称
	 */
	protected String goodTypeName;

	/**
	 * 
	 */
	protected String goodKindId;

	/**
	 * 商品类别名称
	 */
	protected String goodKindName;

	/**
	 * 
	 */
	protected String brandId;

	/**
	 * 
	 */
	protected String brandName;

	/**
	 * 
	 */
	protected String supplierId;

	/**
	 * 
	 */
	protected String supplierName;

	/**
	 * 
	 */
	protected String unit;

	/**
	 * 
	 */
	protected BigDecimal purchasePrice;

	/**
	 * 
	 */
	protected BigDecimal price;

	/**
	 * 
	 */
	protected BigDecimal priceMarket;

	/**
	 * 团购价
	 */
	protected BigDecimal priceGroupBuy;

	/**
	 * 积分
	 */
	protected Integer credits;

	/**
	 * 
	 */
	protected String picId;

	/**
	 * 商品图片
	 */
	protected String pic;

	/**
	 * 
	 */
	protected String tag;

	/**
	 * 上架时间
	 */
	protected Date beginSaleTime;

	/**
	 * 下架时间
	 */
	protected Date endSaleTime;

	/**
	 * 
	 */
	protected Integer orderMultiple;

	/**
	 * 
	 */
	protected Integer totalSales;

	/**
	 * 
	 */
	protected Integer dailyNetSales;

	/**
	 * 
	 */
	protected Integer purchaseNum;

	/**
	 * 
	 */
	protected BigDecimal totalCostInventory;

	/**
	 * 
	 */
	protected BigDecimal averageCostInventory;

	/**
	 * 
	 */
	protected Integer inventoryMin;

	/**
	 * 
	 */
	protected Integer inventoryMax;

	/**
	 * 0或空:不显示 1:显示 
	 */
	protected String indexShow;

	/**
	 * 
	 */
	protected String barcode;

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
	 * 数据状态 c:草稿 s;审核 d:下架
	 */
	protected String state;

	/**
	 * 0普通 1团购
	 */
	protected String isInventory;

	/**
	 * 期初初始数量
	 */
	protected BigDecimal initialnum;

	/**
	 * 税率
	 */
	protected BigDecimal taxRate;

	/**
	 * 含税单价
	 */
	protected BigDecimal taxPrice;

	/**
	 * 商品属性
	 */
	protected String property;

	/**
	 * 
	 */
	protected String remark;

	/**
	 * 
	 */
	protected String areaId;

	/**
	 * 
	 */
	protected BigDecimal clickNumber;

	/**
	 * 
	 */
	protected String deliveryId;

	/**
	 * 
	 */
	protected String paymentId;

	/**
	 * 商品的评论数
	 */
	protected Integer commentCount;

	/**
	 * 
	 */
	protected Integer sort;

	/**
	 * 
	 */
	protected Integer groupNumber;

	/**
	 * 开始团购时间/开始抢购时间/开始秒杀时间
	 */
	protected Date beginTime;

	/**
	 * 
	 */
	protected Integer version;

	/**
	 *  结束团购时间/结束抢购时间/结束秒杀时间
	 */
	protected Date endTime;

	/**
	 * 下期预告
	 */
	protected String isNext;

	/**
	 * 返点比率
	 */
	protected BigDecimal returnRate;

	/**
	 * 返点价格
	 */
	protected BigDecimal returnPrice;

	/**
	 * 活动商品上架多少件
	 */
	protected String activitNumber;

	/**
	 * 
	 */
	protected String isView;

	/**
	 * 抢购/秒杀数量
	 */
	protected String totalNum;

	/**
	 * 取得 商品id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 商品id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 取得 商品编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置 商品编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 取得 品名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 品名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得 商品类别编码
	 */
	public String getGoodTypeId() {
		return goodTypeId;
	}

	/**
	 * 设置 商品类别编码
	 */
	public void setGoodTypeId(String goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

	/**
	 * 取得 商品类别名称
	 */
	public String getGoodTypeName() {
		return goodTypeName;
	}

	/**
	 * 设置 商品类别名称
	 */
	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	/**
	 * 取得 
	 */
	public String getGoodKindId() {
		return goodKindId;
	}

	/**
	 * 设置 
	 */
	public void setGoodKindId(String goodKindId) {
		this.goodKindId = goodKindId;
	}

	/**
	 * 取得 商品类别名称
	 */
	public String getGoodKindName() {
		return goodKindName;
	}

	/**
	 * 设置 商品类别名称
	 */
	public void setGoodKindName(String goodKindName) {
		this.goodKindName = goodKindName;
	}

	/**
	 * 取得 
	 */
	public String getBrandId() {
		return brandId;
	}

	/**
	 * 设置 
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	/**
	 * 取得 
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 设置 
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * 取得 
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * 设置 
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * 取得 
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * 设置 
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * 取得 
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 设置 
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * 设置 
	 */
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置 
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getPriceMarket() {
		return priceMarket;
	}

	/**
	 * 设置 
	 */
	public void setPriceMarket(BigDecimal priceMarket) {
		this.priceMarket = priceMarket;
	}

	/**
	 * 取得 团购价
	 */
	public BigDecimal getPriceGroupBuy() {
		return priceGroupBuy;
	}

	/**
	 * 设置 团购价
	 */
	public void setPriceGroupBuy(BigDecimal priceGroupBuy) {
		this.priceGroupBuy = priceGroupBuy;
	}

	/**
	 * 取得 积分
	 */
	public Integer getCredits() {
		return credits;
	}

	/**
	 * 设置 积分
	 */
	public void setCredits(Integer credits) {
		this.credits = credits;
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
	 * 取得 商品图片
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * 设置 商品图片
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * 取得 
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * 设置 
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * 取得 上架时间
	 */
	public Date getBeginSaleTime() {
		return beginSaleTime;
	}

	/**
	 * 设置 上架时间
	 */
	public void setBeginSaleTime(Date beginSaleTime) {
		this.beginSaleTime = beginSaleTime;
	}

	/**
	 * 取得 下架时间
	 */
	public Date getEndSaleTime() {
		return endSaleTime;
	}

	/**
	 * 设置 下架时间
	 */
	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

	/**
	 * 取得 
	 */
	public Integer getOrderMultiple() {
		return orderMultiple;
	}

	/**
	 * 设置 
	 */
	public void setOrderMultiple(Integer orderMultiple) {
		this.orderMultiple = orderMultiple;
	}

	/**
	 * 取得 
	 */
	public Integer getTotalSales() {
		return totalSales;
	}

	/**
	 * 设置 
	 */
	public void setTotalSales(Integer totalSales) {
		this.totalSales = totalSales;
	}

	/**
	 * 取得 
	 */
	public Integer getDailyNetSales() {
		return dailyNetSales;
	}

	/**
	 * 设置 
	 */
	public void setDailyNetSales(Integer dailyNetSales) {
		this.dailyNetSales = dailyNetSales;
	}

	/**
	 * 取得 
	 */
	public Integer getPurchaseNum() {
		return purchaseNum;
	}

	/**
	 * 设置 
	 */
	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getTotalCostInventory() {
		return totalCostInventory;
	}

	/**
	 * 设置 
	 */
	public void setTotalCostInventory(BigDecimal totalCostInventory) {
		this.totalCostInventory = totalCostInventory;
	}

	/**
	 * 取得 
	 */
	public BigDecimal getAverageCostInventory() {
		return averageCostInventory;
	}

	/**
	 * 设置 
	 */
	public void setAverageCostInventory(BigDecimal averageCostInventory) {
		this.averageCostInventory = averageCostInventory;
	}

	/**
	 * 取得 
	 */
	public Integer getInventoryMin() {
		return inventoryMin;
	}

	/**
	 * 设置 
	 */
	public void setInventoryMin(Integer inventoryMin) {
		this.inventoryMin = inventoryMin;
	}

	/**
	 * 取得 
	 */
	public Integer getInventoryMax() {
		return inventoryMax;
	}

	/**
	 * 设置 
	 */
	public void setInventoryMax(Integer inventoryMax) {
		this.inventoryMax = inventoryMax;
	}

	/**
	 * 取得 0或空:不显示 1:显示 
	 */
	public String getIndexShow() {
		return indexShow;
	}

	/**
	 * 设置 0或空:不显示 1:显示 
	 */
	public void setIndexShow(String indexShow) {
		this.indexShow = indexShow;
	}

	/**
	 * 取得 
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * 设置 
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	 * 取得 数据状态 c:草稿 s;审核 d:下架
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置 数据状态 c:草稿 s;审核 d:下架
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 取得 0普通 1团购
	 */
	public String getIsInventory() {
		return isInventory;
	}

	/**
	 * 设置 0普通 1团购
	 */
	public void setIsInventory(String isInventory) {
		this.isInventory = isInventory;
	}

	/**
	 * 取得 期初初始数量
	 */
	public BigDecimal getInitialnum() {
		return initialnum;
	}

	/**
	 * 设置 期初初始数量
	 */
	public void setInitialnum(BigDecimal initialnum) {
		this.initialnum = initialnum;
	}

	/**
	 * 取得 税率
	 */
	public BigDecimal getTaxRate() {
		return taxRate;
	}

	/**
	 * 设置 税率
	 */
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * 取得 含税单价
	 */
	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	/**
	 * 设置 含税单价
	 */
	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	/**
	 * 取得 商品属性
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * 设置 商品属性
	 */
	public void setProperty(String property) {
		this.property = property;
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
	public BigDecimal getClickNumber() {
		return clickNumber;
	}

	/**
	 * 设置 
	 */
	public void setClickNumber(BigDecimal clickNumber) {
		this.clickNumber = clickNumber;
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
	 * 取得 商品的评论数
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * 设置 商品的评论数
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * 取得 
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置 
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 取得 
	 */
	public Integer getGroupNumber() {
		return groupNumber;
	}

	/**
	 * 设置 
	 */
	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}

	/**
	 * 取得 开始团购时间/开始抢购时间/开始秒杀时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * 设置 开始团购时间/开始抢购时间/开始秒杀时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 取得 
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 设置 
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 取得  结束团购时间/结束抢购时间/结束秒杀时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 设置  结束团购时间/结束抢购时间/结束秒杀时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 取得 下期预告
	 */
	public String getIsNext() {
		return isNext;
	}

	/**
	 * 设置 下期预告
	 */
	public void setIsNext(String isNext) {
		this.isNext = isNext;
	}

	/**
	 * 取得 返点比率
	 */
	public BigDecimal getReturnRate() {
		return returnRate;
	}

	/**
	 * 设置 返点比率
	 */
	public void setReturnRate(BigDecimal returnRate) {
		this.returnRate = returnRate;
	}

	/**
	 * 取得 返点价格
	 */
	public BigDecimal getReturnPrice() {
		return returnPrice;
	}

	/**
	 * 设置 返点价格
	 */
	public void setReturnPrice(BigDecimal returnPrice) {
		this.returnPrice = returnPrice;
	}

	/**
	 * 取得 活动商品上架多少件
	 */
	public String getActivitNumber() {
		return activitNumber;
	}

	/**
	 * 设置 活动商品上架多少件
	 */
	public void setActivitNumber(String activitNumber) {
		this.activitNumber = activitNumber;
	}

	/**
	 * 取得 
	 */
	public String getIsView() {
		return isView;
	}

	/**
	 * 设置 
	 */
	public void setIsView(String isView) {
		this.isView = isView;
	}

	/**
	 * 取得 抢购/秒杀数量
	 */
	public String getTotalNum() {
		return totalNum;
	}

	/**
	 * 设置 抢购/秒杀数量
	 */
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}