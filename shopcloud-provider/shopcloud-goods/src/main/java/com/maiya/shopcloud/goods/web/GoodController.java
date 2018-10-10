package com.maiya.shopcloud.goods.web;

import com.maiya.shopcloud.base.wrapper.WrapMapper;
import com.maiya.shopcloud.base.wrapper.Wrapper;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务
 */
@RestController
@RequestMapping(value = "/good", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - GoodController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodController {

    @Resource
    GoodService goodService;

    /**
     * 查询商品列表
     *
     * @return
     */
    @GetMapping(value = "/queryGoodList")
    @ApiOperation(httpMethod = "GET", value = "查询商品列表")
    public Wrapper queryGoodListWithPage() {

        List<GoodDO> goodDOList = goodService.selectByExample(new GoodDO());

        return WrapMapper.ok(goodDOList);
    }

    /**
     * 查询热卖商品列表
     *
     * @return
     */
    @GetMapping(value = "/queryPopulardHotGood")
    @ApiOperation(httpMethod = "GET", value = "查询热卖商品列表")
    public Wrapper queryPopulardHotGood() {

        List<GoodDO> goodDOList = goodService.queryPopulardHotGood();

        return WrapMapper.ok(goodDOList);
    }


}
