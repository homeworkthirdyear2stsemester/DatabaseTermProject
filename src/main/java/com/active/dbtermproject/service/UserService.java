package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Customer;
import com.active.dbtermproject.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private CustomerDao customerDao;

    public int insertService(Customer customer) {
        return this.customerDao.insert(customer);
    }

    public List<String> getAllUserNames() {
        return this.customerDao.getAllUserNames();
    }
}
