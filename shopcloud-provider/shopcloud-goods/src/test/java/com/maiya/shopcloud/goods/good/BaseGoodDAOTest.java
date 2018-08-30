package com.maiya.shopcloud.goods.good;

import static org.junit.Assert.*;

import com.maiya.shopcloud.goods.dao.good.GoodDAO;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;

import com.maiya.shopcloud.base.mybatis.MybatisBaseDAOImpl;
import com.maiya.shopcloud.base.pagination.Page;
import com.maiya.shopcloud.base.utils.DateTimeUtils;

/**
 * 访问接口单元测试类
 * @author		byu.peng
 * @create		2018-08-19 14:52:52
 */
public abstract class BaseGoodDAOTest{
	/**
	 * 系统日志输出句柄
	 */
	protected final Logger logger = LoggerFactory.getLogger(BaseGoodDAOTest.class);

	/**
	 * 访问接口
	 */
    @Autowired
	protected GoodDAO dao;

    protected String id;

    @Before
    public void setup() {
        testInsert();
    }

    @After
    public void clear() {
        //测试删除操作
        testDelete();
    }

	/**
	 * 测试插入操作
	 * @return
	 */
	private void testInsert() {
		// 构造对象
		GoodDO insertAflEO = new GoodDO();

		insertAflEO.setId(insertId);
		insertAflEO.setCode(insertCode);
		insertAflEO.setName(insertName);
		insertAflEO.setGoodTypeId(insertGoodTypeId);
		insertAflEO.setGoodTypeName(insertGoodTypeName);
		insertAflEO.setGoodKindId(insertGoodKindId);
		insertAflEO.setGoodKindName(insertGoodKindName);
		insertAflEO.setBrandId(insertBrandId);
		insertAflEO.setBrandName(insertBrandName);
		insertAflEO.setSupplierId(insertSupplierId);
		insertAflEO.setSupplierName(insertSupplierName);
		insertAflEO.setUnit(insertUnit);
		insertAflEO.setPurchasePrice(insertPurchasePrice);
		insertAflEO.setPrice(insertPrice);
		insertAflEO.setPriceMarket(insertPriceMarket);
		insertAflEO.setPriceGroupBuy(insertPriceGroupBuy);
		insertAflEO.setCredits(insertCredits);
		insertAflEO.setPicId(insertPicId);
		insertAflEO.setPic(insertPic);
		insertAflEO.setTag(insertTag);
		insertAflEO.setBeginSaleTime(insertBeginSaleTime);
		insertAflEO.setEndSaleTime(insertEndSaleTime);
		insertAflEO.setOrderMultiple(insertOrderMultiple);
		insertAflEO.setTotalSales(insertTotalSales);
		insertAflEO.setDailyNetSales(insertDailyNetSales);
		insertAflEO.setPurchaseNum(insertPurchaseNum);
		insertAflEO.setTotalCostInventory(insertTotalCostInventory);
		insertAflEO.setAverageCostInventory(insertAverageCostInventory);
		insertAflEO.setInventoryMin(insertInventoryMin);
		insertAflEO.setInventoryMax(insertInventoryMax);
		insertAflEO.setIndexShow(insertIndexShow);
		insertAflEO.setBarcode(insertBarcode);
		insertAflEO.setCreatorId(insertCreatorId);
		insertAflEO.setCreatorName(insertCreatorName);
		insertAflEO.setCreateTime(insertCreateTime);
		insertAflEO.setModifierId(insertModifierId);
		insertAflEO.setModifierName(insertModifierName);
		insertAflEO.setModifyTime(insertModifyTime);
		insertAflEO.setState(insertState);
		insertAflEO.setIsInventory(insertIsInventory);
		insertAflEO.setInitialnum(insertInitialnum);
		insertAflEO.setTaxRate(insertTaxRate);
		insertAflEO.setTaxPrice(insertTaxPrice);
		insertAflEO.setProperty(insertProperty);
		insertAflEO.setRemark(insertRemark);
		insertAflEO.setAreaId(insertAreaId);
		insertAflEO.setClickNumber(insertClickNumber);
		insertAflEO.setDeliveryId(insertDeliveryId);
		insertAflEO.setPaymentId(insertPaymentId);
		insertAflEO.setCommentCount(insertCommentCount);
		insertAflEO.setSort(insertSort);
		insertAflEO.setGroupNumber(insertGroupNumber);
		insertAflEO.setBeginTime(insertBeginTime);
		insertAflEO.setEndTime(insertEndTime);
		insertAflEO.setIsNext(insertIsNext);
		insertAflEO.setReturnRate(insertReturnRate);
		insertAflEO.setReturnPrice(insertReturnPrice);
		insertAflEO.setActivitNumber(insertActivitNumber);
		insertAflEO.setIsView(insertIsView);
		insertAflEO.setTotalNum(insertTotalNum);
		
		//执行插入
        id = dao.insert(insertAflEO);
		assertNotNull(id);
	}

	/**
	 * 测试查询操作
	 * @param id
	 * @param selectEO
	 * @return 
	 */
    @Test
	public void testSelect() {
		//执行查询
		GoodDO selectEO = dao.select(id);
		
		//判断查询出的数据是否正确
		assertEquals(id,selectEO.getId());
		assertEquals(insertCode,selectEO.getCode().trim());
		assertEquals(insertName,selectEO.getName().trim());
		assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
		assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
		assertEquals(insertGoodKindId,selectEO.getGoodKindId().trim());
		assertEquals(insertGoodKindName,selectEO.getGoodKindName().trim());
		assertEquals(insertBrandId,selectEO.getBrandId().trim());
		assertEquals(insertBrandName,selectEO.getBrandName().trim());
		assertEquals(insertSupplierId,selectEO.getSupplierId().trim());
		assertEquals(insertSupplierName,selectEO.getSupplierName().trim());
		assertEquals(insertUnit,selectEO.getUnit().trim());
		assertEquals(insertPurchasePrice,selectEO.getPurchasePrice());
		assertEquals(insertPrice,selectEO.getPrice());
		assertEquals(insertPriceMarket,selectEO.getPriceMarket());
		assertEquals(insertPriceGroupBuy,selectEO.getPriceGroupBuy());
		assertEquals(insertCredits,selectEO.getCredits());
		assertEquals(insertPicId,selectEO.getPicId().trim());
		assertEquals(insertPic,selectEO.getPic().trim());
		assertEquals(insertTag,selectEO.getTag().trim());
		assertEquals(insertBeginSaleTime,selectEO.getBeginSaleTime());
		assertEquals(insertEndSaleTime,selectEO.getEndSaleTime());
		assertEquals(insertOrderMultiple,selectEO.getOrderMultiple());
		assertEquals(insertTotalSales,selectEO.getTotalSales());
		assertEquals(insertDailyNetSales,selectEO.getDailyNetSales());
		assertEquals(insertPurchaseNum,selectEO.getPurchaseNum());
		assertEquals(insertTotalCostInventory,selectEO.getTotalCostInventory());
		assertEquals(insertAverageCostInventory,selectEO.getAverageCostInventory());
		assertEquals(insertInventoryMin,selectEO.getInventoryMin());
		assertEquals(insertInventoryMax,selectEO.getInventoryMax());
		assertEquals(insertIndexShow,selectEO.getIndexShow().trim());
		assertEquals(insertBarcode,selectEO.getBarcode().trim());
		assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
		assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
		assertEquals(insertCreateTime,selectEO.getCreateTime());
		assertEquals(insertModifierId,selectEO.getModifierId().trim());
		assertEquals(insertModifierName,selectEO.getModifierName().trim());
		assertEquals(insertModifyTime,selectEO.getModifyTime());
		assertEquals(insertState,selectEO.getState().trim());
		assertEquals(insertIsInventory,selectEO.getIsInventory().trim());
		assertEquals(insertInitialnum,selectEO.getInitialnum());
		assertEquals(insertTaxRate,selectEO.getTaxRate());
		assertEquals(insertTaxPrice,selectEO.getTaxPrice());
		assertEquals(insertProperty,selectEO.getProperty().trim());
		assertEquals(insertRemark,selectEO.getRemark().trim());
		assertEquals(insertAreaId,selectEO.getAreaId().trim());
		assertEquals(insertClickNumber,selectEO.getClickNumber());
		assertEquals(insertDeliveryId,selectEO.getDeliveryId().trim());
		assertEquals(insertPaymentId,selectEO.getPaymentId().trim());
		assertEquals(insertCommentCount,selectEO.getCommentCount());
		assertEquals(insertSort,selectEO.getSort());
		assertEquals(insertGroupNumber,selectEO.getGroupNumber());
		assertEquals(insertBeginTime,selectEO.getBeginTime());
		assertEquals(insertEndTime,selectEO.getEndTime());
		assertEquals(insertIsNext,selectEO.getIsNext().trim());
		assertEquals(insertReturnRate,selectEO.getReturnRate());
		assertEquals(insertReturnPrice,selectEO.getReturnPrice());
		assertEquals(insertActivitNumber,selectEO.getActivitNumber().trim());
		assertEquals(insertIsView,selectEO.getIsView().trim());
		assertEquals(insertTotalNum,selectEO.getTotalNum().trim());
	}

    /**
     * 测试根据对象查询操作
     * @param selectEO
     * @return
     */
    @Test
    public void testSelectByEO() {
        GoodDO eo = dao.select(id);
        GoodDO selectEO = dao.selectByEO(eo);

        assertEquals(id,selectEO.getId());
        assertEquals(insertCode,selectEO.getCode().trim());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
        assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
        assertEquals(insertGoodKindId,selectEO.getGoodKindId().trim());
        assertEquals(insertGoodKindName,selectEO.getGoodKindName().trim());
        assertEquals(insertBrandId,selectEO.getBrandId().trim());
        assertEquals(insertBrandName,selectEO.getBrandName().trim());
        assertEquals(insertSupplierId,selectEO.getSupplierId().trim());
        assertEquals(insertSupplierName,selectEO.getSupplierName().trim());
        assertEquals(insertUnit,selectEO.getUnit().trim());
        assertEquals(insertPurchasePrice,selectEO.getPurchasePrice());
        assertEquals(insertPrice,selectEO.getPrice());
        assertEquals(insertPriceMarket,selectEO.getPriceMarket());
        assertEquals(insertPriceGroupBuy,selectEO.getPriceGroupBuy());
        assertEquals(insertCredits,selectEO.getCredits());
        assertEquals(insertPicId,selectEO.getPicId().trim());
        assertEquals(insertPic,selectEO.getPic().trim());
        assertEquals(insertTag,selectEO.getTag().trim());
        assertEquals(insertBeginSaleTime,selectEO.getBeginSaleTime());
        assertEquals(insertEndSaleTime,selectEO.getEndSaleTime());
        assertEquals(insertOrderMultiple,selectEO.getOrderMultiple());
        assertEquals(insertTotalSales,selectEO.getTotalSales());
        assertEquals(insertDailyNetSales,selectEO.getDailyNetSales());
        assertEquals(insertPurchaseNum,selectEO.getPurchaseNum());
        assertEquals(insertTotalCostInventory,selectEO.getTotalCostInventory());
        assertEquals(insertAverageCostInventory,selectEO.getAverageCostInventory());
        assertEquals(insertInventoryMin,selectEO.getInventoryMin());
        assertEquals(insertInventoryMax,selectEO.getInventoryMax());
        assertEquals(insertIndexShow,selectEO.getIndexShow().trim());
        assertEquals(insertBarcode,selectEO.getBarcode().trim());
        assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
        assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
        assertEquals(insertCreateTime,selectEO.getCreateTime());
        assertEquals(insertModifierId,selectEO.getModifierId().trim());
        assertEquals(insertModifierName,selectEO.getModifierName().trim());
        assertEquals(insertModifyTime,selectEO.getModifyTime());
        assertEquals(insertState,selectEO.getState().trim());
        assertEquals(insertIsInventory,selectEO.getIsInventory().trim());
        assertEquals(insertInitialnum,selectEO.getInitialnum());
        assertEquals(insertTaxRate,selectEO.getTaxRate());
        assertEquals(insertTaxPrice,selectEO.getTaxPrice());
        assertEquals(insertProperty,selectEO.getProperty().trim());
        assertEquals(insertRemark,selectEO.getRemark().trim());
        assertEquals(insertAreaId,selectEO.getAreaId().trim());
        assertEquals(insertClickNumber,selectEO.getClickNumber());
        assertEquals(insertDeliveryId,selectEO.getDeliveryId().trim());
        assertEquals(insertPaymentId,selectEO.getPaymentId().trim());
        assertEquals(insertCommentCount,selectEO.getCommentCount());
        assertEquals(insertSort,selectEO.getSort());
        assertEquals(insertGroupNumber,selectEO.getGroupNumber());
        assertEquals(insertBeginTime,selectEO.getBeginTime());
        assertEquals(insertEndTime,selectEO.getEndTime());
        assertEquals(insertIsNext,selectEO.getIsNext().trim());
        assertEquals(insertReturnRate,selectEO.getReturnRate());
        assertEquals(insertReturnPrice,selectEO.getReturnPrice());
        assertEquals(insertActivitNumber,selectEO.getActivitNumber().trim());
        assertEquals(insertIsView,selectEO.getIsView().trim());
        assertEquals(insertTotalNum,selectEO.getTotalNum().trim());
    }

    /**
     * 测试根据对象查询List操作
     * @param selectEO
     * @return
     */
    @Test
    public void testSelectListByEO() {
        GoodDO eo = dao.select(id);
        List<GoodDO> resultList = dao.selectListByEO(eo);

        assertEquals(1, resultList.size());
        GoodDO selectEO = resultList.get(0);

            assertEquals(id,selectEO.getId());
        assertEquals(insertCode,selectEO.getCode().trim());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
        assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
        assertEquals(insertGoodKindId,selectEO.getGoodKindId().trim());
        assertEquals(insertGoodKindName,selectEO.getGoodKindName().trim());
        assertEquals(insertBrandId,selectEO.getBrandId().trim());
        assertEquals(insertBrandName,selectEO.getBrandName().trim());
        assertEquals(insertSupplierId,selectEO.getSupplierId().trim());
        assertEquals(insertSupplierName,selectEO.getSupplierName().trim());
        assertEquals(insertUnit,selectEO.getUnit().trim());
        assertEquals(insertPurchasePrice,selectEO.getPurchasePrice());
        assertEquals(insertPrice,selectEO.getPrice());
        assertEquals(insertPriceMarket,selectEO.getPriceMarket());
        assertEquals(insertPriceGroupBuy,selectEO.getPriceGroupBuy());
        assertEquals(insertCredits,selectEO.getCredits());
        assertEquals(insertPicId,selectEO.getPicId().trim());
        assertEquals(insertPic,selectEO.getPic().trim());
        assertEquals(insertTag,selectEO.getTag().trim());
        assertEquals(insertBeginSaleTime,selectEO.getBeginSaleTime());
        assertEquals(insertEndSaleTime,selectEO.getEndSaleTime());
        assertEquals(insertOrderMultiple,selectEO.getOrderMultiple());
        assertEquals(insertTotalSales,selectEO.getTotalSales());
        assertEquals(insertDailyNetSales,selectEO.getDailyNetSales());
        assertEquals(insertPurchaseNum,selectEO.getPurchaseNum());
        assertEquals(insertTotalCostInventory,selectEO.getTotalCostInventory());
        assertEquals(insertAverageCostInventory,selectEO.getAverageCostInventory());
        assertEquals(insertInventoryMin,selectEO.getInventoryMin());
        assertEquals(insertInventoryMax,selectEO.getInventoryMax());
        assertEquals(insertIndexShow,selectEO.getIndexShow().trim());
        assertEquals(insertBarcode,selectEO.getBarcode().trim());
        assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
        assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
        assertEquals(insertCreateTime,selectEO.getCreateTime());
        assertEquals(insertModifierId,selectEO.getModifierId().trim());
        assertEquals(insertModifierName,selectEO.getModifierName().trim());
        assertEquals(insertModifyTime,selectEO.getModifyTime());
        assertEquals(insertState,selectEO.getState().trim());
        assertEquals(insertIsInventory,selectEO.getIsInventory().trim());
        assertEquals(insertInitialnum,selectEO.getInitialnum());
        assertEquals(insertTaxRate,selectEO.getTaxRate());
        assertEquals(insertTaxPrice,selectEO.getTaxPrice());
        assertEquals(insertProperty,selectEO.getProperty().trim());
        assertEquals(insertRemark,selectEO.getRemark().trim());
        assertEquals(insertAreaId,selectEO.getAreaId().trim());
        assertEquals(insertClickNumber,selectEO.getClickNumber());
        assertEquals(insertDeliveryId,selectEO.getDeliveryId().trim());
        assertEquals(insertPaymentId,selectEO.getPaymentId().trim());
        assertEquals(insertCommentCount,selectEO.getCommentCount());
        assertEquals(insertSort,selectEO.getSort());
        assertEquals(insertGroupNumber,selectEO.getGroupNumber());
        assertEquals(insertBeginTime,selectEO.getBeginTime());
        assertEquals(insertEndTime,selectEO.getEndTime());
        assertEquals(insertIsNext,selectEO.getIsNext().trim());
        assertEquals(insertReturnRate,selectEO.getReturnRate());
        assertEquals(insertReturnPrice,selectEO.getReturnPrice());
        assertEquals(insertActivitNumber,selectEO.getActivitNumber().trim());
        assertEquals(insertIsView,selectEO.getIsView().trim());
        assertEquals(insertTotalNum,selectEO.getTotalNum().trim());
    }

    /**
     * 测试根据对象分页查询操作
     * @param selectEO
     * @return
    */
    @Test
    public void testQueryForPage() {
        GoodDO eo = dao.select(id);
        Page<GoodDO> page = new Page<GoodDO>();
        page.setPageNo(1);
        page.setPageSize(10);
        Page<GoodDO> resultPage = dao.queryForPage(eo, page);

        assertEquals(1, resultPage.getTotalCount());
        GoodDO selectEO = resultPage.getResult().get(0);

        assertEquals(id,selectEO.getId());
        assertEquals(insertCode,selectEO.getCode().trim());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertGoodTypeId,selectEO.getGoodTypeId().trim());
        assertEquals(insertGoodTypeName,selectEO.getGoodTypeName().trim());
        assertEquals(insertGoodKindId,selectEO.getGoodKindId().trim());
        assertEquals(insertGoodKindName,selectEO.getGoodKindName().trim());
        assertEquals(insertBrandId,selectEO.getBrandId().trim());
        assertEquals(insertBrandName,selectEO.getBrandName().trim());
        assertEquals(insertSupplierId,selectEO.getSupplierId().trim());
        assertEquals(insertSupplierName,selectEO.getSupplierName().trim());
        assertEquals(insertUnit,selectEO.getUnit().trim());
        assertEquals(insertPurchasePrice,selectEO.getPurchasePrice());
        assertEquals(insertPrice,selectEO.getPrice());
        assertEquals(insertPriceMarket,selectEO.getPriceMarket());
        assertEquals(insertPriceGroupBuy,selectEO.getPriceGroupBuy());
        assertEquals(insertCredits,selectEO.getCredits());
        assertEquals(insertPicId,selectEO.getPicId().trim());
        assertEquals(insertPic,selectEO.getPic().trim());
        assertEquals(insertTag,selectEO.getTag().trim());
        assertEquals(insertBeginSaleTime,selectEO.getBeginSaleTime());
        assertEquals(insertEndSaleTime,selectEO.getEndSaleTime());
        assertEquals(insertOrderMultiple,selectEO.getOrderMultiple());
        assertEquals(insertTotalSales,selectEO.getTotalSales());
        assertEquals(insertDailyNetSales,selectEO.getDailyNetSales());
        assertEquals(insertPurchaseNum,selectEO.getPurchaseNum());
        assertEquals(insertTotalCostInventory,selectEO.getTotalCostInventory());
        assertEquals(insertAverageCostInventory,selectEO.getAverageCostInventory());
        assertEquals(insertInventoryMin,selectEO.getInventoryMin());
        assertEquals(insertInventoryMax,selectEO.getInventoryMax());
        assertEquals(insertIndexShow,selectEO.getIndexShow().trim());
        assertEquals(insertBarcode,selectEO.getBarcode().trim());
        assertEquals(insertCreatorId,selectEO.getCreatorId().trim());
        assertEquals(insertCreatorName,selectEO.getCreatorName().trim());
        assertEquals(insertCreateTime,selectEO.getCreateTime());
        assertEquals(insertModifierId,selectEO.getModifierId().trim());
        assertEquals(insertModifierName,selectEO.getModifierName().trim());
        assertEquals(insertModifyTime,selectEO.getModifyTime());
        assertEquals(insertState,selectEO.getState().trim());
        assertEquals(insertIsInventory,selectEO.getIsInventory().trim());
        assertEquals(insertInitialnum,selectEO.getInitialnum());
        assertEquals(insertTaxRate,selectEO.getTaxRate());
        assertEquals(insertTaxPrice,selectEO.getTaxPrice());
        assertEquals(insertProperty,selectEO.getProperty().trim());
        assertEquals(insertRemark,selectEO.getRemark().trim());
        assertEquals(insertAreaId,selectEO.getAreaId().trim());
        assertEquals(insertClickNumber,selectEO.getClickNumber());
        assertEquals(insertDeliveryId,selectEO.getDeliveryId().trim());
        assertEquals(insertPaymentId,selectEO.getPaymentId().trim());
        assertEquals(insertCommentCount,selectEO.getCommentCount());
        assertEquals(insertSort,selectEO.getSort());
        assertEquals(insertGroupNumber,selectEO.getGroupNumber());
        assertEquals(insertBeginTime,selectEO.getBeginTime());
        assertEquals(insertEndTime,selectEO.getEndTime());
        assertEquals(insertIsNext,selectEO.getIsNext().trim());
        assertEquals(insertReturnRate,selectEO.getReturnRate());
        assertEquals(insertReturnPrice,selectEO.getReturnPrice());
        assertEquals(insertActivitNumber,selectEO.getActivitNumber().trim());
        assertEquals(insertIsView,selectEO.getIsView().trim());
        assertEquals(insertTotalNum,selectEO.getTotalNum().trim());
        }

	/**
	 * 测试更新操作
	 * @param id 被更新记录的主键
	 * @param selectEO 被更新的EO对象
	 */
    @Test
    public void testUpdate() {
        GoodDO selectEO = dao.select(id);

		// 更改各个字段的值
		selectEO.setCode(updateCode);
		selectEO.setName(updateName);
		selectEO.setGoodTypeId(updateGoodTypeId);
		selectEO.setGoodTypeName(updateGoodTypeName);
		selectEO.setGoodKindId(updateGoodKindId);
		selectEO.setGoodKindName(updateGoodKindName);
		selectEO.setBrandId(updateBrandId);
		selectEO.setBrandName(updateBrandName);
		selectEO.setSupplierId(updateSupplierId);
		selectEO.setSupplierName(updateSupplierName);
		selectEO.setUnit(updateUnit);
		selectEO.setPurchasePrice(updatePurchasePrice);
		selectEO.setPrice(updatePrice);
		selectEO.setPriceMarket(updatePriceMarket);
		selectEO.setPriceGroupBuy(updatePriceGroupBuy);
		selectEO.setCredits(updateCredits);
		selectEO.setPicId(updatePicId);
		selectEO.setPic(updatePic);
		selectEO.setTag(updateTag);
		selectEO.setBeginSaleTime(updateBeginSaleTime);
		selectEO.setEndSaleTime(updateEndSaleTime);
		selectEO.setOrderMultiple(updateOrderMultiple);
		selectEO.setTotalSales(updateTotalSales);
		selectEO.setDailyNetSales(updateDailyNetSales);
		selectEO.setPurchaseNum(updatePurchaseNum);
		selectEO.setTotalCostInventory(updateTotalCostInventory);
		selectEO.setAverageCostInventory(updateAverageCostInventory);
		selectEO.setInventoryMin(updateInventoryMin);
		selectEO.setInventoryMax(updateInventoryMax);
		selectEO.setIndexShow(updateIndexShow);
		selectEO.setBarcode(updateBarcode);
		selectEO.setCreatorId(updateCreatorId);
		selectEO.setCreatorName(updateCreatorName);
		selectEO.setCreateTime(updateCreateTime);
		selectEO.setModifierId(updateModifierId);
		selectEO.setModifierName(updateModifierName);
		selectEO.setModifyTime(updateModifyTime);
		selectEO.setState(updateState);
		selectEO.setIsInventory(updateIsInventory);
		selectEO.setInitialnum(updateInitialnum);
		selectEO.setTaxRate(updateTaxRate);
		selectEO.setTaxPrice(updateTaxPrice);
		selectEO.setProperty(updateProperty);
		selectEO.setRemark(updateRemark);
		selectEO.setAreaId(updateAreaId);
		selectEO.setClickNumber(updateClickNumber);
		selectEO.setDeliveryId(updateDeliveryId);
		selectEO.setPaymentId(updatePaymentId);
		selectEO.setCommentCount(updateCommentCount);
		selectEO.setSort(updateSort);
		selectEO.setGroupNumber(updateGroupNumber);
		selectEO.setBeginTime(updateBeginTime);
		selectEO.setEndTime(updateEndTime);
		selectEO.setIsNext(updateIsNext);
		selectEO.setReturnRate(updateReturnRate);
		selectEO.setReturnPrice(updateReturnPrice);
		selectEO.setActivitNumber(updateActivitNumber);
		selectEO.setIsView(updateIsView);
		selectEO.setTotalNum(updateTotalNum);
		
		//执行更新操作
		int updateCount = dao.update(selectEO);
		assertEquals(1,updateCount);

        }
	
	/**
	 * 测试更新操作
	 * @param id 被更新记录的主键
	 * @param selectEO 被更新的EO对象
	 */
    @Test
    public void testUpdateField() {
        GoodDO selectEO = dao.select(id);

		// 更改各个字段的值
		selectEO.setCode(updateFieldCode);
		selectEO.setName(updateFieldName);
		selectEO.setGoodTypeId(updateFieldGoodTypeId);
		selectEO.setGoodTypeName(updateFieldGoodTypeName);
		selectEO.setGoodKindId(updateFieldGoodKindId);
		selectEO.setGoodKindName(updateFieldGoodKindName);
		selectEO.setBrandId(updateFieldBrandId);
		selectEO.setBrandName(updateFieldBrandName);
		selectEO.setSupplierId(updateFieldSupplierId);
		selectEO.setSupplierName(updateFieldSupplierName);
		selectEO.setUnit(updateFieldUnit);
		selectEO.setPurchasePrice(updateFieldPurchasePrice);
		selectEO.setPrice(updateFieldPrice);
		selectEO.setPriceMarket(updateFieldPriceMarket);
		selectEO.setPriceGroupBuy(updateFieldPriceGroupBuy);
		selectEO.setCredits(updateFieldCredits);
		selectEO.setPicId(updateFieldPicId);
		selectEO.setPic(updateFieldPic);
		selectEO.setTag(updateFieldTag);
		selectEO.setBeginSaleTime(updateFieldBeginSaleTime);
		selectEO.setEndSaleTime(updateFieldEndSaleTime);
		selectEO.setOrderMultiple(updateFieldOrderMultiple);
		selectEO.setTotalSales(updateFieldTotalSales);
		selectEO.setDailyNetSales(updateFieldDailyNetSales);
		selectEO.setPurchaseNum(updateFieldPurchaseNum);
		selectEO.setTotalCostInventory(updateFieldTotalCostInventory);
		selectEO.setAverageCostInventory(updateFieldAverageCostInventory);
		selectEO.setInventoryMin(updateFieldInventoryMin);
		selectEO.setInventoryMax(updateFieldInventoryMax);
		selectEO.setIndexShow(updateFieldIndexShow);
		selectEO.setBarcode(updateFieldBarcode);
		selectEO.setCreatorId(updateFieldCreatorId);
		selectEO.setCreatorName(updateFieldCreatorName);
		selectEO.setCreateTime(updateFieldCreateTime);
		selectEO.setModifierId(updateFieldModifierId);
		selectEO.setModifierName(updateFieldModifierName);
		selectEO.setModifyTime(updateFieldModifyTime);
		selectEO.setState(updateFieldState);
		selectEO.setIsInventory(updateFieldIsInventory);
		selectEO.setInitialnum(updateFieldInitialnum);
		selectEO.setTaxRate(updateFieldTaxRate);
		selectEO.setTaxPrice(updateFieldTaxPrice);
		selectEO.setProperty(updateFieldProperty);
		selectEO.setRemark(updateFieldRemark);
		selectEO.setAreaId(updateFieldAreaId);
		selectEO.setClickNumber(updateFieldClickNumber);
		selectEO.setDeliveryId(updateFieldDeliveryId);
		selectEO.setPaymentId(updateFieldPaymentId);
		selectEO.setCommentCount(updateFieldCommentCount);
		selectEO.setSort(updateFieldSort);
		selectEO.setGroupNumber(updateFieldGroupNumber);
		selectEO.setBeginTime(updateFieldBeginTime);
		selectEO.setEndTime(updateFieldEndTime);
		selectEO.setIsNext(updateFieldIsNext);
		selectEO.setReturnRate(updateFieldReturnRate);
		selectEO.setReturnPrice(updateFieldReturnPrice);
		selectEO.setActivitNumber(updateFieldActivitNumber);
		selectEO.setIsView(updateFieldIsView);
		selectEO.setTotalNum(updateFieldTotalNum);

        GoodDO old = new GoodDO();
        old.setId(id);
	
		//执行更新操作
		int updateCount = dao.updateByField(old, selectEO);
		assertEquals(1,updateCount);
	}

	/**
	 * 测试删除操作
	 * @param id 被删除记录的主键
	 * @param selectEO 被删除的EO对象
	 */
	private void testDelete() {
        // 构造对象
        GoodDO selectEO = new GoodDO();
        selectEO.setId(id);

		// 执行删除操作
		dao.delete(selectEO);

        GoodDO result = dao.select(id);

		assertNull(result);
	}


    //////////////////////////insert的初始数据//////////////////////////////////////////////////

    /**
     * 商品id
     */
    private String insertId = "20180819145252002751";

    /**
     * 商品编码
     */
    private String insertCode = "1";

    /**
     * 品名
     */
    private String insertName = "1";

    /**
     * 商品类别编码
     */
    private String insertGoodTypeId = "1";

    /**
     * 商品类别名称
     */
    private String insertGoodTypeName = "1";

    /**
     * 
     */
    private String insertGoodKindId = "1";

    /**
     * 商品类别名称
     */
    private String insertGoodKindName = "1";

    /**
     * 
     */
    private String insertBrandId = "1";

    /**
     * 
     */
    private String insertBrandName = "1";

    /**
     * 
     */
    private String insertSupplierId = "1";

    /**
     * 
     */
    private String insertSupplierName = "1";

    /**
     * 
     */
    private String insertUnit = "1";

    /**
     * 
     */
    private BigDecimal insertPurchasePrice = new BigDecimal("1");

    /**
     * 
     */
    private BigDecimal insertPrice = new BigDecimal("1");

    /**
     * 
     */
    private BigDecimal insertPriceMarket = new BigDecimal("1");

    /**
     * 团购价
     */
    private BigDecimal insertPriceGroupBuy = new BigDecimal("1");

    /**
     * 积分
     */
    private Integer insertCredits = new Integer("1");

    /**
     * 
     */
    private String insertPicId = "1";

    /**
     * 商品图片
     */
    private String insertPic = "1";

    /**
     * 
     */
    private String insertTag = "1";

    /**
     * 上架时间
     */
    private Date insertBeginSaleTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 下架时间
     */
    private Date insertEndSaleTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 
     */
    private Integer insertOrderMultiple = new Integer("1");

    /**
     * 
     */
    private Integer insertTotalSales = new Integer("1");

    /**
     * 
     */
    private Integer insertDailyNetSales = new Integer("1");

    /**
     * 
     */
    private Integer insertPurchaseNum = new Integer("1");

    /**
     * 
     */
    private BigDecimal insertTotalCostInventory = new BigDecimal("1");

    /**
     * 
     */
    private BigDecimal insertAverageCostInventory = new BigDecimal("1");

    /**
     * 
     */
    private Integer insertInventoryMin = new Integer("1");

    /**
     * 
     */
    private Integer insertInventoryMax = new Integer("1");

    /**
     * 0或空:不显示 1:显示 
     */
    private String insertIndexShow = "1";

    /**
     * 
     */
    private String insertBarcode = "1";

    /**
     * 创建人id
     */
    private String insertCreatorId = "1";

    /**
     * 创建人姓名
     */
    private String insertCreatorName = "1";

    /**
     * 创建时间
     */
    private Date insertCreateTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 修改人id
     */
    private String insertModifierId = "1";

    /**
     * 修改人姓名
     */
    private String insertModifierName = "1";

    /**
     * 修改时间
     */
    private Date insertModifyTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 数据状态 c:草稿 s;审核 d:下架
     */
    private String insertState = "1";

    /**
     * 0普通 1团购
     */
    private String insertIsInventory = "1";

    /**
     * 期初初始数量
     */
    private BigDecimal insertInitialnum = new BigDecimal("1");

    /**
     * 税率
     */
    private BigDecimal insertTaxRate = new BigDecimal("1");

    /**
     * 含税单价
     */
    private BigDecimal insertTaxPrice = new BigDecimal("1");

    /**
     * 商品属性
     */
    private String insertProperty = "1";

    /**
     * 
     */
    private String insertRemark = "1";

    /**
     * 
     */
    private String insertAreaId = "1";

    /**
     * 
     */
    private BigDecimal insertClickNumber = new BigDecimal("1");

    /**
     * 
     */
    private String insertDeliveryId = "1";

    /**
     * 
     */
    private String insertPaymentId = "1";

    /**
     * 商品的评论数
     */
    private Integer insertCommentCount = new Integer("1");

    /**
     * 
     */
    private Integer insertSort = new Integer("1");

    /**
     * 
     */
    private Integer insertGroupNumber = new Integer("1");

    /**
     * 开始团购时间/开始抢购时间/开始秒杀时间
     */
    private Date insertBeginTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     *  结束团购时间/结束抢购时间/结束秒杀时间
     */
    private Date insertEndTime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 下期预告
     */
    private String insertIsNext = "1";

    /**
     * 返点比率
     */
    private BigDecimal insertReturnRate = new BigDecimal("1");

    /**
     * 返点价格
     */
    private BigDecimal insertReturnPrice = new BigDecimal("1");

    /**
     * 活动商品上架多少件
     */
    private String insertActivitNumber = "1";

    /**
     * 
     */
    private String insertIsView = "1";

    /**
     * 抢购/秒杀数量
     */
    private String insertTotalNum = "1";


    ////////////////////////////update的初始数据/////////////////////////////////////////////////

    /**
     * 商品编码
     */
    private String updateCode = "2";

    /**
     * 品名
     */
    private String updateName = "2";

    /**
     * 商品类别编码
     */
    private String updateGoodTypeId = "2";

    /**
     * 商品类别名称
     */
    private String updateGoodTypeName = "2";

    /**
     * 
     */
    private String updateGoodKindId = "2";

    /**
     * 商品类别名称
     */
    private String updateGoodKindName = "2";

    /**
     * 
     */
    private String updateBrandId = "2";

    /**
     * 
     */
    private String updateBrandName = "2";

    /**
     * 
     */
    private String updateSupplierId = "2";

    /**
     * 
     */
    private String updateSupplierName = "2";

    /**
     * 
     */
    private String updateUnit = "2";

    /**
     * 
     */
    private BigDecimal updatePurchasePrice = new BigDecimal("2");

    /**
     * 
     */
    private BigDecimal updatePrice = new BigDecimal("2");

    /**
     * 
     */
    private BigDecimal updatePriceMarket = new BigDecimal("2");

    /**
     * 团购价
     */
    private BigDecimal updatePriceGroupBuy = new BigDecimal("2");

    /**
     * 积分
     */
    private Integer updateCredits = new Integer("2");

    /**
     * 
     */
    private String updatePicId = "2";

    /**
     * 商品图片
     */
    private String updatePic = "2";

    /**
     * 
     */
    private String updateTag = "2";

    /**
     * 上架时间
     */
    private Date updateBeginSaleTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 下架时间
     */
    private Date updateEndSaleTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 
     */
    private Integer updateOrderMultiple = new Integer("2");

    /**
     * 
     */
    private Integer updateTotalSales = new Integer("2");

    /**
     * 
     */
    private Integer updateDailyNetSales = new Integer("2");

    /**
     * 
     */
    private Integer updatePurchaseNum = new Integer("2");

    /**
     * 
     */
    private BigDecimal updateTotalCostInventory = new BigDecimal("2");

    /**
     * 
     */
    private BigDecimal updateAverageCostInventory = new BigDecimal("2");

    /**
     * 
     */
    private Integer updateInventoryMin = new Integer("2");

    /**
     * 
     */
    private Integer updateInventoryMax = new Integer("2");

    /**
     * 0或空:不显示 1:显示 
     */
    private String updateIndexShow = "2";

    /**
     * 
     */
    private String updateBarcode = "2";

    /**
     * 创建人id
     */
    private String updateCreatorId = "2";

    /**
     * 创建人姓名
     */
    private String updateCreatorName = "2";

    /**
     * 创建时间
     */
    private Date updateCreateTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 修改人id
     */
    private String updateModifierId = "2";

    /**
     * 修改人姓名
     */
    private String updateModifierName = "2";

    /**
     * 修改时间
     */
    private Date updateModifyTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 数据状态 c:草稿 s;审核 d:下架
     */
    private String updateState = "2";

    /**
     * 0普通 1团购
     */
    private String updateIsInventory = "2";

    /**
     * 期初初始数量
     */
    private BigDecimal updateInitialnum = new BigDecimal("2");

    /**
     * 税率
     */
    private BigDecimal updateTaxRate = new BigDecimal("2");

    /**
     * 含税单价
     */
    private BigDecimal updateTaxPrice = new BigDecimal("2");

    /**
     * 商品属性
     */
    private String updateProperty = "2";

    /**
     * 
     */
    private String updateRemark = "2";

    /**
     * 
     */
    private String updateAreaId = "2";

    /**
     * 
     */
    private BigDecimal updateClickNumber = new BigDecimal("2");

    /**
     * 
     */
    private String updateDeliveryId = "2";

    /**
     * 
     */
    private String updatePaymentId = "2";

    /**
     * 商品的评论数
     */
    private Integer updateCommentCount = new Integer("2");

    /**
     * 
     */
    private Integer updateSort = new Integer("2");

    /**
     * 
     */
    private Integer updateGroupNumber = new Integer("2");

    /**
     * 开始团购时间/开始抢购时间/开始秒杀时间
     */
    private Date updateBeginTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     *  结束团购时间/结束抢购时间/结束秒杀时间
     */
    private Date updateEndTime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 下期预告
     */
    private String updateIsNext = "2";

    /**
     * 返点比率
     */
    private BigDecimal updateReturnRate = new BigDecimal("2");

    /**
     * 返点价格
     */
    private BigDecimal updateReturnPrice = new BigDecimal("2");

    /**
     * 活动商品上架多少件
     */
    private String updateActivitNumber = "2";

    /**
     * 
     */
    private String updateIsView = "2";

    /**
     * 抢购/秒杀数量
     */
    private String updateTotalNum = "2";


////////////////////////////update field的初始数据/////////////////////////////////////////////////

    /**
     * 商品编码
     */
    private String updateFieldCode = "3";

    /**
     * 品名
     */
    private String updateFieldName = "3";

    /**
     * 商品类别编码
     */
    private String updateFieldGoodTypeId = "3";

    /**
     * 商品类别名称
     */
    private String updateFieldGoodTypeName = "3";

    /**
     * 
     */
    private String updateFieldGoodKindId = "3";

    /**
     * 商品类别名称
     */
    private String updateFieldGoodKindName = "3";

    /**
     * 
     */
    private String updateFieldBrandId = "3";

    /**
     * 
     */
    private String updateFieldBrandName = "3";

    /**
     * 
     */
    private String updateFieldSupplierId = "3";

    /**
     * 
     */
    private String updateFieldSupplierName = "3";

    /**
     * 
     */
    private String updateFieldUnit = "3";

    /**
     * 
     */
    private BigDecimal updateFieldPurchasePrice = new BigDecimal("3");

    /**
     * 
     */
    private BigDecimal updateFieldPrice = new BigDecimal("3");

    /**
     * 
     */
    private BigDecimal updateFieldPriceMarket = new BigDecimal("3");

    /**
     * 团购价
     */
    private BigDecimal updateFieldPriceGroupBuy = new BigDecimal("3");

    /**
     * 积分
     */
    private Integer updateFieldCredits = new Integer("3");

    /**
     * 
     */
    private String updateFieldPicId = "3";

    /**
     * 商品图片
     */
    private String updateFieldPic = "3";

    /**
     * 
     */
    private String updateFieldTag = "3";

    /**
     * 上架时间
     */
    private Date updateFieldBeginSaleTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 下架时间
     */
    private Date updateFieldEndSaleTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 
     */
    private Integer updateFieldOrderMultiple = new Integer("3");

    /**
     * 
     */
    private Integer updateFieldTotalSales = new Integer("3");

    /**
     * 
     */
    private Integer updateFieldDailyNetSales = new Integer("3");

    /**
     * 
     */
    private Integer updateFieldPurchaseNum = new Integer("3");

    /**
     * 
     */
    private BigDecimal updateFieldTotalCostInventory = new BigDecimal("3");

    /**
     * 
     */
    private BigDecimal updateFieldAverageCostInventory = new BigDecimal("3");

    /**
     * 
     */
    private Integer updateFieldInventoryMin = new Integer("3");

    /**
     * 
     */
    private Integer updateFieldInventoryMax = new Integer("3");

    /**
     * 0或空:不显示 1:显示 
     */
    private String updateFieldIndexShow = "3";

    /**
     * 
     */
    private String updateFieldBarcode = "3";

    /**
     * 创建人id
     */
    private String updateFieldCreatorId = "3";

    /**
     * 创建人姓名
     */
    private String updateFieldCreatorName = "3";

    /**
     * 创建时间
     */
    private Date updateFieldCreateTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 修改人id
     */
    private String updateFieldModifierId = "3";

    /**
     * 修改人姓名
     */
    private String updateFieldModifierName = "3";

    /**
     * 修改时间
     */
    private Date updateFieldModifyTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 数据状态 c:草稿 s;审核 d:下架
     */
    private String updateFieldState = "3";

    /**
     * 0普通 1团购
     */
    private String updateFieldIsInventory = "3";

    /**
     * 期初初始数量
     */
    private BigDecimal updateFieldInitialnum = new BigDecimal("3");

    /**
     * 税率
     */
    private BigDecimal updateFieldTaxRate = new BigDecimal("3");

    /**
     * 含税单价
     */
    private BigDecimal updateFieldTaxPrice = new BigDecimal("3");

    /**
     * 商品属性
     */
    private String updateFieldProperty = "3";

    /**
     * 
     */
    private String updateFieldRemark = "3";

    /**
     * 
     */
    private String updateFieldAreaId = "3";

    /**
     * 
     */
    private BigDecimal updateFieldClickNumber = new BigDecimal("3");

    /**
     * 
     */
    private String updateFieldDeliveryId = "3";

    /**
     * 
     */
    private String updateFieldPaymentId = "3";

    /**
     * 商品的评论数
     */
    private Integer updateFieldCommentCount = new Integer("3");

    /**
     * 
     */
    private Integer updateFieldSort = new Integer("3");

    /**
     * 
     */
    private Integer updateFieldGroupNumber = new Integer("3");

    /**
     * 开始团购时间/开始抢购时间/开始秒杀时间
     */
    private Date updateFieldBeginTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     *  结束团购时间/结束抢购时间/结束秒杀时间
     */
    private Date updateFieldEndTime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 下期预告
     */
    private String updateFieldIsNext = "3";

    /**
     * 返点比率
     */
    private BigDecimal updateFieldReturnRate = new BigDecimal("3");

    /**
     * 返点价格
     */
    private BigDecimal updateFieldReturnPrice = new BigDecimal("3");

    /**
     * 活动商品上架多少件
     */
    private String updateFieldActivitNumber = "3";

    /**
     * 
     */
    private String updateFieldIsView = "3";

    /**
     * 抢购/秒杀数量
     */
    private String updateFieldTotalNum = "3";

}
