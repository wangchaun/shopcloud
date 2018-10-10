package com.maiya.shopcloud.goods.service.impl;


import com.maiya.shopcloud.goods.dao.good.GoodDAO;
import com.maiya.shopcloud.goods.dao.good.GoodDAOImpl;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.service.GoodService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodServiceImpl  implements GoodService {

    @Resource
    GoodDAO goodDAO;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<GoodDO> select(GoodDO record) {
        return null;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public GoodDO selectByKey(String key) {
        return goodDAO.select(key);
    }

    @Override
    public List<GoodDO> selectAll() {
        return null;
    }

    @Override
    public GoodDO selectOne(GoodDO record) {
        return null;
    }

    @Override
    public int selectCount(GoodDO record) {
        return 0;
    }

    @Override
    public String save(GoodDO record) {
        return goodDAO.insert(record);
    }

    @Override
    public int batchSave(List<GoodDO> list) {
        return 0;
    }

    @Override
    public int update(GoodDO entity) {
        return 0;
    }

    @Override
    public int delete(GoodDO record) {
        return 0;
    }

    @Override
    public int batchDelete(List<GoodDO> list) {
        return 0;
    }

    @Override
    public int deleteByKey(String key) {
        return 0;
    }

    @Override
    public List<GoodDO> selectByExample(GoodDO entity) {
        return goodDAO.selectListByEO(entity);
    }

    @Override
    public int selectCountByExample(GoodDO entity) {
        return goodDAO.countByEO(entity);
    }
    @Override
    public int updateByExample(GoodDO record, Object example) {
        return 0;
    }

    @Override
    public int deleteByExample(Object example) {
        return 0;
    }

    @Override
    public List<GoodDO> selectByRowBounds(GoodDO record, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<GoodDO> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<GoodDO> queryPopulardHotGood() {

        GoodDO goodDOCnd=new GoodDO();
        goodDOCnd.setProperty("1");
        goodDOCnd.setIsInventory("0");
        goodDOCnd.setIndexShow("1");
        goodDOCnd.setState("s");

        return goodDAO.selectListByEO(goodDOCnd);

    }
}
