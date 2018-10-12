package com.maiya.shopcloud.account.web;


import com.maiya.shopcloud.account.dao.customer.CustomerDO;
import com.maiya.shopcloud.account.service.CustomerService;
import com.maiya.shopcloud.account.service.RandomValidateService;
import com.maiya.shopcloud.base.wrapper.WrapMapper;
import com.maiya.shopcloud.base.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户服务
 */
@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - CustomerController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    CustomerService customerService;

    @Resource
    RandomValidateService randomValidateService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "/queryCustomerList")
    @ApiOperation(httpMethod = "GET", value = "查询用户列表")
    public Wrapper queryGoodListWithPage() {
        logger.info("begin query customer list");
        List<CustomerDO> customerDOList = customerService.selectAll();
        logger.info("query end");
        return WrapMapper.ok(customerDOList);
    }

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "/error")
    @ApiOperation(httpMethod = "GET", value = "查询用户列表")
    public Wrapper error() {
        logger.info("error list");
        System.out.print(5/0);
        logger.info("error end");
        return WrapMapper.ok(5/0);
    }
    /**
     * 获取验证码
     * @return
     */
    @GetMapping(value = "/getValidatePicture")
    @ApiOperation(httpMethod = "GET", value = "获取验证码")
    public void getValidatePic(HttpServletRequest request, HttpServletResponse response) {
        randomValidateService.getRandcode(request,response);
    }
    /**
     * 校验验证码
     * @return
     */
    @PostMapping(value = "/checkValidatePicture")
    @ApiOperation(httpMethod = "POST", value = "校验验证码")
    public void checkValidatePicture(String validateKey, HttpServletRequest request, HttpServletResponse response) {
        randomValidateService.checkValidateKey(validateKey, request, response);
    }

    /**
     * 注册
     * @return
     */
    @GetMapping(value = "/register")
    @ApiOperation(httpMethod = "POST", value = "注册")
    public void login(HttpServletRequest request, HttpServletResponse response) {


    }
}
