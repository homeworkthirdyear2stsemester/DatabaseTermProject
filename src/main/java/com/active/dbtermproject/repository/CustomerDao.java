package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao { // db접근 함수들

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllUserNames() {
        List<String> userNameList = new ArrayList<>();
        userNameList.addAll(this.jdbcTemplate.queryForList("select name from user", String.class));

        return userNameList;
    }

    // 회원 가입
    public int insert(Customer customer) {
        return this.jdbcTemplate.update(
                "insert customer values(?, ?, ?, ?, ?, ?)",
                customer.getId(), customer.getPassword(),
                customer.getEmail(), customer.getName(),
                customer.getPhoneNumber(), customer.getType()
        );
    }

    // 회원 탈퇴
    public int delete(Customer customer) {
        return this.jdbcTemplate.update(
                "delete from customer where id=?",
                customer.getId()
        );
    }

    // 회원 정보 수정
    public int update() {
        return -1;
    }
}
