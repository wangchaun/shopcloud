package com.maiya.shopcloud.account.service.impl;

import com.maiya.shopcloud.account.dao.customer.CustomerDAO;
import com.maiya.shopcloud.account.dao.customer.CustomerDO;
import com.maiya.shopcloud.account.service.CustomerService;
import com.maiya.shopcloud.account.util.CommonUtil;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDAO customerDAO;

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public List<CustomerDO> select(CustomerDO record) {
        return null;
    }

    @Override
    public CustomerDO selectByKey(String key) {
        return null;
    }

    @Override
    public List<CustomerDO> selectAll() {
        return customerDAO.selectListByEO(new CustomerDO());
    }

    @Override
    public CustomerDO selectOne(CustomerDO record) {
        return null;
    }

    @Override
    public int selectCount(CustomerDO record) {
        return 0;
    }

    @Override
    public String save(CustomerDO record) {
        return null;
    }

    @Override
    public int batchSave(List<CustomerDO> list) {
        return 0;
    }

    @Override
    public int update(CustomerDO entity) {
        return 0;
    }

    @Override
    public int delete(CustomerDO record) {
        return 0;
    }

    @Override
    public int batchDelete(List<CustomerDO> list) {
        return 0;
    }

    @Override
    public int deleteByKey(String key) {
        return 0;
    }

    @Override
    public List<CustomerDO> selectByExample(CustomerDO entity) {
        return null;
    }

    @Override
    public int selectCountByExample(CustomerDO entity) {
        return 0;
    }

    @Override
    public int updateByExample(CustomerDO record, Object example) {
        return 0;
    }

    @Override
    public int deleteByExample(Object example) {
        return 0;
    }

    @Override
    public List<CustomerDO> selectByRowBounds(CustomerDO record, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CustomerDO> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public void registerCustomer(CustomerDO customerDO, HttpServletRequest request, HttpServletResponse response) {
        try {

            customerDO.setId(UUID.randomUUID().toString().substring(0,32));
            customerDO.setState("s");
            customerDO.setType("0");
            customerDO.setIsPinlessemail("0");
            customerDO.setIsPinlessmobile("0");
            customerDO.setCreateTime(new Date());
            customerDO.setName(customerDO.getCode());
            customerDO.setCredit(0);
            customerDO.setClintip(CommonUtil.getIpAddr(request));
            customerDO.setPwd(CommonUtil.encodePassWord(customerDO.getPwd()));
            customerDO.setAgree("我已经阅读并同意《网上商城用户协议书》");
            customerDAO.insert(customerDO);

            request.getSession().setAttribute("loginCustomer",customerDO);
            request.setAttribute("loginCustomer",customerDO);
            logger.info("register customer:{}",customerDO.toString());
            response.getWriter().write("true");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("register customer error1:{}", e);
            try {
                response.getWriter().write("false");
            } catch (IOException ex){
                logger.error("register customer error2:{}", ex);
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void login(CustomerDO customerDO, HttpServletRequest request, HttpServletResponse response) {
        try {
            String code = customerDO.getCode();
            String pwd = customerDO.getPwd();
            customerDO.setPwd(null);
            CustomerDO customerDO1   = customerDAO.selectByEO(customerDO);
            String pwdDB = CommonUtil.decodePassWord(customerDO1.getPwd());

            if (pwd.equals(pwdDB)){
                request.getSession().setAttribute("loginCustomer",customerDO);
                request.setAttribute("loginCustomer",customerDO);
                logger.info("login customer:{}",customerDO.toString());
                response.getWriter().write("true");
            }else {
                response.getWriter().write("false");
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("register customer error1:{}", e);
            try {
                response.getWriter().write("false");
            } catch (IOException ex){
                logger.error("register customer error2:{}", ex);
                ex.printStackTrace();
            }
        }
    }


}
