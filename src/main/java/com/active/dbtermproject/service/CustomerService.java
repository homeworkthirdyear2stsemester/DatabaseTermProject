package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Customer;
import com.active.dbtermproject.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private CustomerDao customerDao;

    // 회원 가입 : insert Customer
    public int insertService(Customer customer) {
        return this.customerDao.insert(customer);
    }

    // 회원 삭제 : delete Customer
    public int deleteService(Customer customer) {
        return this.customerDao.delete(customer);
    }

    public List<String> getAllUserNames() {
        return this.customerDao.getAllUserNames();
    }
}
