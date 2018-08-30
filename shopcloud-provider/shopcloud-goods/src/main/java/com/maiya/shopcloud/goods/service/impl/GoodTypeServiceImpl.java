package com.maiya.shopcloud.goods.service.impl;

import com.maiya.shopcloud.goods.dao.goodtype.GoodTypeDAO;
import com.maiya.shopcloud.goods.dao.goodtype.GoodTypeDO;
import com.maiya.shopcloud.goods.model.vo.GoodTypeVo;
import com.maiya.shopcloud.goods.service.GoodTypeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodTypeServiceImpl implements GoodTypeService {

    @Resource
    GoodTypeDAO goodTypeDAO;

	public List<GoodTypeVo> queryTypeTree(){

        GoodTypeDO goodtype = new GoodTypeDO();
        goodtype.setLevel(Integer.valueOf(1));
        goodtype.setListshow("1");
        List<GoodTypeDO> goodTypeDOS= goodTypeDAO.selectListByEO(goodtype);

        List<GoodTypeVo> goodTypeVoList=this.getGoodTypeVoList(goodTypeDOS);

        this.getChildren(goodTypeVoList);

        return goodTypeVoList;
    }

    public List<GoodTypeVo> getGoodTypeVoList(List<GoodTypeDO> goodTypeDOS){

        List<GoodTypeVo> goodTypeVoList=new ArrayList<>();

        for(GoodTypeDO goodTypeDO:goodTypeDOS){
            GoodTypeVo goodTypeVo=new GoodTypeVo();
            BeanUtils.copyProperties(goodTypeDO,goodTypeVo);
            goodTypeVoList.add(goodTypeVo);
        }
        return  goodTypeVoList;
    }

    public void getChildren(List<GoodTypeVo> goodTypeVoList)
    {
        if ((goodTypeVoList != null) && (!goodTypeVoList.isEmpty()))
            for (GoodTypeVo goodType : goodTypeVoList)
                if (goodType != null) {
                    String parentId = goodType.getId();
                    Integer level = Integer.valueOf(goodType.getLevel().intValue() + 1);

                    GoodTypeDO condition=new GoodTypeDO();
                    condition.setParentId(parentId);
                    condition.setLevel(level);

                    List<GoodTypeVo> children=this.getGoodTypeVoList(goodTypeDAO.selectListByEO(condition));

                    if ((children != null) && (!children.isEmpty())) {
                        goodType.setChildren(children);
                        getChildren(children);
                    }
                }
    }


    @Override
    public List<GoodTypeDO> select(GoodTypeDO record) {
        return null;
    }

    @Override
    public GoodTypeDO selectByKey(String key) {
        return null;
    }

    @Override
    public List<GoodTypeDO> selectAll() {
        return null;
    }

    @Override
    public GoodTypeDO selectOne(GoodTypeDO record) {
        return null;
    }

    @Override
    public int selectCount(GoodTypeDO record) {
        return 0;
    }

    @Override
    public String save(GoodTypeDO record) {
        return null;
    }

    @Override
    public int batchSave(List<GoodTypeDO> list) {
        return 0;
    }

    @Override
    public int update(GoodTypeDO entity) {
        return 0;
    }

    @Override
    public int delete(GoodTypeDO record) {
        return 0;
    }

    @Override
    public int batchDelete(List<GoodTypeDO> list) {
        return 0;
    }

    @Override
    public int deleteByKey(String key) {
        return 0;
    }

    @Override
    public List<GoodTypeDO> selectByExample(GoodTypeDO entity) {
        return null;
    }

    @Override
    public int selectCountByExample(GoodTypeDO entity) {
        return 0;
    }

    @Override
    public int updateByExample(GoodTypeDO record, Object example) {
        return 0;
    }

    @Override
    public int deleteByExample(Object example) {
        return 0;
    }

    @Override
    public List<GoodTypeDO> selectByRowBounds(GoodTypeDO record, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<GoodTypeDO> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return null;
    }
}
