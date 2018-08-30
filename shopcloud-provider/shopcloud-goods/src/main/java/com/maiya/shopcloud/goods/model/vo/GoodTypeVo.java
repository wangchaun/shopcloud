package com.maiya.shopcloud.goods.model.vo;

import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.dao.goodtype.GoodTypeDO;

import java.io.Serializable;
import java.util.List;

public class GoodTypeVo implements Serializable {

    private String id;
    private String code;
    private String name;
    private Integer level;
    private String remark;
    private String levelString;
    private String picId;
    private String pic;
    private String listShow;
    private List<GoodTypeVo> children;
    private String isInventories;
    private List<GoodDO> goodlist;
    private String index;
    private String searchType;
    private String paymentId;
    private String paymentName;
    private String deliveryId;
    private String deliveryName;
    private String[] wareIdArr;
    private Integer warehousecount;
    private String isParent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevelString() {
        return levelString;
    }

    public void setLevelString(String levelString) {
        this.levelString = levelString;
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

    public String getListShow() {
        return listShow;
    }

    public void setListShow(String listShow) {
        this.listShow = listShow;
    }

    public String getIsInventories() {
        return isInventories;
    }

    public void setIsInventories(String isInventories) {
        this.isInventories = isInventories;
    }

    public List<GoodDO> getGoodlist() {
        return goodlist;
    }

    public void setGoodlist(List<GoodDO> goodlist) {
        this.goodlist = goodlist;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String[] getWareIdArr() {
        return wareIdArr;
    }

    public void setWareIdArr(String[] wareIdArr) {
        this.wareIdArr = wareIdArr;
    }

    public Integer getWarehousecount() {
        return warehousecount;
    }

    public void setWarehousecount(Integer warehousecount) {
        this.warehousecount = warehousecount;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public List<GoodTypeVo> getChildren() {
        return children;
    }

    public void setChildren(List<GoodTypeVo> children) {
        this.children = children;
    }
}
