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
    // id, password, email, name, phoneNumber, type 필요
    public int insertService(Customer customer) {
        return this.customerDao.insert(customer);
    }

    // 회원 삭제 : delete Customer
    // id 필요
    public int deleteService(String customerId) {
        return this.customerDao.delete(customerId);
    }

    // 회원 정보 수정 : update Customer
    // parameter
    //  - customer : 변경 대상 회원의 정보.
    //               id 필요
    //  - newInfo : 변경 후의 회원 정보
    //               password, email, name, phoneNumber, type 필요
    public int updateService(Customer customer, Customer newInfo) {
        return this.customerDao.update(customer, newInfo);
    }

    // id에 해당하는 customer 객체를 반환하는 함수
    public Customer getCustomerByIdService(String customerId) {
        return this.customerDao.getCustomerById(customerId);
    }

    // 모든 회원들 반환 (Customer table 전체 반환)
    /**
     *
     * @return : 모든 Customer들 List
     */
    public List<Customer> getAllCustomers() {
        // 여기부터 작성 해야해
        return customerDao.getAllCustomers();
    }
}
