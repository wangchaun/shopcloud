package com.maiya.shopcloud.goods.web;

import com.github.pagehelper.PageInfo;
import com.maiya.shopcloud.base.wrapper.WrapMapper;
import com.maiya.shopcloud.base.wrapper.Wrapper;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.service.GoodService;
import com.maiya.shopcloud.goods.service.impl.GoodServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
      * @return
     */
    @GetMapping(value = "/queryGoodList")
    @ApiOperation(httpMethod = "GET", value = "查询商品列表")
    public Wrapper queryGoodListWithPage() {
        List<GoodDO> goodDOList=goodService.selectByExample(new GoodDO());
        return WrapMapper.ok(goodDOList);
    }
}