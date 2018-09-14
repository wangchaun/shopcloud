package com.maiya.shopcloud.account.web;


import com.maiya.shopcloud.account.dao.customer.CustomerDO;
import com.maiya.shopcloud.account.service.CustomerService;
import com.maiya.shopcloud.base.wrapper.WrapMapper;
import com.maiya.shopcloud.base.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * 用户服务
 */
@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - CustomerController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {


    @Resource
    CustomerService customerService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "/queryCustomerList")
    @ApiOperation(httpMethod = "GET", value = "查询用户列表")
    public Wrapper queryGoodListWithPage() {
        List<CustomerDO> customerDOList = customerService.select(new CustomerDO());
        return WrapMapper.ok(customerDOList);
    }
}
