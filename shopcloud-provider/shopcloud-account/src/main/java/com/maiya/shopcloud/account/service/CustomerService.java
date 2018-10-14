package com.maiya.shopcloud.account.service;

import com.maiya.shopcloud.account.dao.customer.CustomerDO;
import com.maiya.shopcloud.base.base.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerService extends IService<CustomerDO> {

    void registerCustomer(CustomerDO customerDO, HttpServletRequest request, HttpServletResponse response);

    void login(CustomerDO customerDO, HttpServletRequest request, HttpServletResponse response);

}
