package com.maiya.shopcloud.account.service.impl;

import com.maiya.shopcloud.account.dao.customer.CustomerDAO;
import com.maiya.shopcloud.account.dao.customer.CustomerDO;
import com.maiya.shopcloud.account.service.CustomerService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDAO customerDAO;

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
}
