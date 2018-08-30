package com.maiya.shopcloud.goods.good;

import static org.junit.Assert.fail;

import com.maiya.shopcloud.goods.ShopcloudGoodsApplicationTests;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.service.GoodService;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maiya.shopcloud.base.utils.DateTimeUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 访问接口单元测试类
 *
 * @author byu.peng
 * @create 2018-08-19 14:52:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodDAOTest extends ShopcloudGoodsApplicationTests {


    @Resource
    GoodService goodService;

    @Test
    public void selectByKeyTest() {
        GoodDO goodDO = new GoodDO();



        List<GoodDO> goodDOS = goodService.selectByExample(goodDO);

        for (GoodDO goodDO2 : goodDOS) {
            GoodDO insertGoodDo=new GoodDO();
            BeanUtils.copyProperties(goodDO2,insertGoodDo);
            insertGoodDo.setId(goodDO2.getId().substring(0,6).concat("b"));
            insertGoodDo.setCreatorName("byu");
            insertGoodDo.setCreateTime(new Date());
            goodService.save(insertGoodDo);
            logger.info("selectByKeyTest = {}", goodDO2.getName());
        }

        logger.info("selectByKeyTest = {}", goodDO.getName());
    }
}
