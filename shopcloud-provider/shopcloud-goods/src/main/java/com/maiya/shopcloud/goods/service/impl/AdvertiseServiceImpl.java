package com.maiya.shopcloud.goods.service.impl;


import com.maiya.shopcloud.goods.dao.advertise.AdvertiseDAO;
import com.maiya.shopcloud.goods.dao.advertise.AdvertiseDO;
import com.maiya.shopcloud.goods.dao.good.GoodDAO;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.model.vo.AdvertiseVo;
import com.maiya.shopcloud.goods.service.AdvertiseService;
import com.maiya.shopcloud.goods.service.GoodService;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdvertiseServiceImpl implements AdvertiseService {

    @Resource
    AdvertiseDAO advertiseDAO;

    public List<AdvertiseVo>getByPlaceAdvertiseList(AdvertiseDO advertiseDO){
        List<AdvertiseDO> advertiseDOList=advertiseDAO.selectListByEO(advertiseDO);

        List<AdvertiseVo>advertiseVos=new ArrayList<>();

        for(AdvertiseDO advertise:advertiseDOList) {
             AdvertiseVo advertiseVo=new AdvertiseVo();
             BeanUtils.copyProperties(advertise,advertiseVo);
             advertiseVos.add(advertiseVo);
        }
        return  advertiseVos;
    }


    @Override
    public List<AdvertiseDO> select(AdvertiseDO record) {
        return advertiseDAO.selectListByEO(record);
    }

    @Override
    public AdvertiseDO selectByKey(String key) {
        return null;
    }

    @Override
    public List<AdvertiseDO> selectAll() {
        return null;
    }

    @Override
    public AdvertiseDO selectOne(AdvertiseDO record) {
        return null;
    }

    @Override
    public int selectCount(AdvertiseDO record) {
        return 0;
    }

    @Override
    public String save(AdvertiseDO record) {
        return null;
    }

    @Override
    public int batchSave(List<AdvertiseDO> list) {
        return 0;
    }

    @Override
    public int update(AdvertiseDO entity) {
        return 0;
    }

    @Override
    public int delete(AdvertiseDO record) {
        return 0;
    }

    @Override
    public int batchDelete(List<AdvertiseDO> list) {
        return 0;
    }

    @Override
    public int deleteByKey(String key) {
        return 0;
    }

    @Override
    public List<AdvertiseDO> selectByExample(AdvertiseDO entity) {
        return null;
    }

    @Override
    public int selectCountByExample(AdvertiseDO entity) {
        return 0;
    }

    @Override
    public int updateByExample(AdvertiseDO record, Object example) {
        return 0;
    }

    @Override
    public int deleteByExample(Object example) {
        return 0;
    }

    @Override
    public List<AdvertiseDO> selectByRowBounds(AdvertiseDO record, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<AdvertiseDO> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return null;
    }
}
