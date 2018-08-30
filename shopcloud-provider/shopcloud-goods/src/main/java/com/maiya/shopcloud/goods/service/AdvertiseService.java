package com.maiya.shopcloud.goods.service;

import com.maiya.shopcloud.base.base.IService;
import com.maiya.shopcloud.goods.dao.advertise.AdvertiseDO;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.model.vo.AdvertiseVo;

import java.util.List;


public interface AdvertiseService extends IService<AdvertiseDO> {


    public List<AdvertiseVo> getByPlaceAdvertiseList(AdvertiseDO advertiseDO);
}
