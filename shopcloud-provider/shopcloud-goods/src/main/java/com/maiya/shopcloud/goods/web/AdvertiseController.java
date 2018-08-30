package com.maiya.shopcloud.goods.web;

import com.maiya.shopcloud.base.wrapper.WrapMapper;
import com.maiya.shopcloud.base.wrapper.Wrapper;
import com.maiya.shopcloud.goods.dao.advertise.AdvertiseDO;
import com.maiya.shopcloud.goods.dao.good.GoodDO;
import com.maiya.shopcloud.goods.model.vo.AdvertiseVo;
import com.maiya.shopcloud.goods.service.AdvertiseService;
import com.maiya.shopcloud.goods.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/advertise", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - AdvertiseController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdvertiseController {

    @Resource
    AdvertiseService advertiseService;

    /**
     * 查询商品列表
      * @return
     */
    @GetMapping(value = "/queryAdvertiseList")
    @ApiOperation(httpMethod = "GET", value = "查询广告列表")
    public Wrapper queryGoodListWithPage() {
        List<AdvertiseVo>advertiseDOList=advertiseService.getByPlaceAdvertiseList(new AdvertiseDO());
        return WrapMapper.ok(advertiseDOList);
    }
}
