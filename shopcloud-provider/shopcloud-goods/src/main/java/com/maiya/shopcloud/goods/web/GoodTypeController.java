package com.maiya.shopcloud.goods.web;

import com.maiya.shopcloud.base.wrapper.WrapMapper;
import com.maiya.shopcloud.base.wrapper.Wrapper;
import com.maiya.shopcloud.goods.model.vo.GoodTypeVo;
import com.maiya.shopcloud.goods.service.GoodTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类别服务
 */
@RestController
@RequestMapping(value = "/goodType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - GoodController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodTypeController {

    @Resource
    GoodTypeService goodTypeService;

    /**
     * 查询商品列表
      * @return
     */
    @GetMapping(value = "/queryTypeTree")
    @ApiOperation(httpMethod = "GET", value = "查询商品类别列表-官网首页")
    public Wrapper queryTypeTree() {
        List<GoodTypeVo> goodTypeVoList=goodTypeService.queryTypeTree();
        return WrapMapper.ok(goodTypeVoList);
    }
}
