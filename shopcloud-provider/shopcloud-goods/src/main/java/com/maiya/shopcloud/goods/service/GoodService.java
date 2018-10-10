package com.maiya.shopcloud.goods.service;

import com.maiya.shopcloud.base.base.IService;
import com.maiya.shopcloud.goods.dao.good.GoodDO;

import java.util.List;


public interface GoodService extends IService<GoodDO> {


    /**
     * 查询人气热卖商品
     * @return
     */
    List<GoodDO> queryPopulardHotGood();
}
