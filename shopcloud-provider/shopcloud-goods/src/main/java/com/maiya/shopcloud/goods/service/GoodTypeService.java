package com.maiya.shopcloud.goods.service;

import com.maiya.shopcloud.base.base.IService;
import com.maiya.shopcloud.goods.dao.goodtype.GoodTypeDO;
import com.maiya.shopcloud.goods.model.vo.GoodTypeVo;

import java.util.List;

public interface GoodTypeService extends IService<GoodTypeDO> {

    List<GoodTypeVo> queryTypeTree();
}
