package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao { // db접근 함수들

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 모든 Customers 검색
    public List<Customer> getAllCustomers() throws Exception {
        return this.jdbcTemplate.query(
                "SELECT * FROM customer",
                (rs, rowNum) -> Customer.builder()
                        .id(rs.getString("id"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .name(rs.getString("name"))
                        .phoneNumber(rs.getString("phone_number"))
                        .type(convertType(rs.getString("type"))).build());
    }

    // 회원 가입
    public int insert(Customer customer) throws Exception {
        return this.jdbcTemplate.update(
                "insert customer values(?, ?, ?, ?, ?, ?)",
                customer.getId(), customer.getPassword(),
                customer.getEmail(), customer.getName(),
                customer.getPhoneNumber(), customer.getType()
        );
    }

    // 회원 탈퇴
    public int delete(String customerId) throws Exception {
        return this.jdbcTemplate.update(
                "delete from customer where id=?",
                customerId
        );
    }

    // 회원 정보 수정
    public int update(String customerId, Customer newInfo) throws Exception {
        return this.jdbcTemplate.update(
                "update customer SET " +
                        "password=?, " +
                        "email=?, " +
                        "name=?, " +
                        "phone_number=?, " +
                        "type=? " +
                        "WHERE id=?",
                newInfo.getPassword(),
                newInfo.getEmail(),
                newInfo.getName(),
                newInfo.getPhoneNumber(),
                newInfo.getType(),
                customerId
        );
    }

    // 관리자인지 확인하는 함수
    public boolean isAdmin(String customerId) throws Exception {
        String type = getTypeById(customerId);
        return type.equals("관리자");
    }

    // id로 customer 검색
    public Customer getCustomerById(String customerId) throws Exception {
        return this.jdbcTemplate.queryForObject(
                "select * from customer c where c.id=?",
                (rs, rowNum) -> Customer.builder()
                        .id(rs.getString("id"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .name(rs.getString("name"))
                        .phoneNumber(rs.getString("phone_number"))
                        .type(convertType(rs.getString("type"))).build(), customerId);
    }

    // id로 해당 customer의 type 검색
    public String getTypeById(String customerId) throws Exception {
        return convertType(jdbcTemplate.queryForObject(
                "select type from customer c where c.id=?",
                new Object[]{customerId}, String.class));
    }

    public String convertType(String type) {
        if(type.equals("10"))
            return "학부생";
        if(type.equals("30"))
            return "대학원생";
        if(type.equals("60"))
            return "교직원";
        return "관리자";
    }
}
