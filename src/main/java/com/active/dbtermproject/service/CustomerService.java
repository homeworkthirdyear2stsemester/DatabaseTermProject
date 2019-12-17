package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Customer;
import com.active.dbtermproject.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private CustomerDao customerDao;

    // 회원 가입 : insert Customer
    /**
     *
     * @param customer : 생성할 회원의 정보. id, password, email, name, phoneNumber, type
     * @return : 성공시 1, 실패시 0
     */
    public int insertService(Customer customer) {
        try {
            return this.customerDao.insert(customer);
        } catch (Exception e) {
            return 0;
        }
    }

    // 회원 삭제 : delete Customer
    /**
     *
     * @param customerId : 삭제할 회원의 id
     * @return : 성공시 1, 실패시 0
     */
    public int deleteService(String customerId) {
        try {
            return this.customerDao.delete(customerId);
        } catch (Exception e) {
            return 0;
        }
    }

    // 회원 정보 수정 : update Customer
    /**
     *
     * @param customerId : 변경 대상 회원의 id
     * @param newInfo : 이 정보들로 변경함. password, email, name, phoneNumber, type
     * @return : 성공시 1, 실패시 0
     */
    public int updateService(String customerId, Customer newInfo) {
        if (customerId == null) {
            return 0;
        }
        try {
            return this.customerDao.update(customerId, newInfo);
        } catch (Exception e) {
            return 0;
        }
    }

    // id에 해당하는 customer 객체를 반환하는 함수
    /**
     *
     * @param customerId : 회원 id
     * @return : 해당 회원 객체, 없으면 null 반환
     */
    public Customer getCustomerByIdService(String customerId) {
        try {
            return this.customerDao.getCustomerById(customerId);
        } catch (Exception e) {
            return null;
        }
    }

    // 모든 회원들 반환 (Customer table 전체 반환)
    /**
     *
     * @return : 모든 회원들 List
     */
    public List<Customer> getAllCustomers() {
        try {
            return customerDao.getAllCustomers();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // 관리자인지 확인하는 함수
    /**
     *
     * @param customerId : 확인할 id
     * @return : 관리자(type="admin")라면 true, 아니라면 false
     */
    public boolean isAdmin(String customerId) {
        try {
            return customerDao.isAdmin(customerId);
        } catch (Exception e) {
            return false;
        }
    }
}
