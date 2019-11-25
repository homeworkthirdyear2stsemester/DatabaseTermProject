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
    /**
     *
     * @param customer : 생성할 회원의 정보. id, password, email, name, phoneNumber, type
     * @return : 성공시 1, 실패시 0
     */
    public int insertService(Customer customer) {
        return this.customerDao.insert(customer);
    }

    // 회원 삭제 : delete Customer
    /**
     *
     * @param customerId : 삭제할 회원의 id
     * @return : 성공시 1, 실패시 0
     */
    public int deleteService(String customerId) {
        return this.customerDao.delete(customerId);
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
            throw new NullPointerException();
        }
        return this.customerDao.update(customerId, newInfo);
    }

    // id에 해당하는 customer 객체를 반환하는 함수
    /**
     *
     * @param customerId : 회원 id
     * @return : 해당 회원 객체
     */
    public Customer getCustomerByIdService(String customerId) {
        return this.customerDao.getCustomerById(customerId);
    }

    // 모든 회원들 반환 (Customer table 전체 반환)
    /**
     *
     * @return : 모든 회원들 List
     */
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    // 관리자인지 확인하는 함수
    /**
     *
     * @param customerId : 확인할 id
     * @return : 관리자(type="admin")라면 true
     */
    public boolean isAdmin(String customerId) {
        return customerDao.isAdmin(customerId);
    }
}
