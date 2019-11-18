package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao { // db접근 함수들

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllUserNames() {
        List<String> userNameList = new ArrayList<>();
        userNameList.addAll(this.jdbcTemplate.queryForList("select name from user", String.class));

        return userNameList;
    }

    public int insert(User user) {
        return this.jdbcTemplate.update(
                "insert into user(id, name) values(?, ?)",
                new Object[]{user.getId(), user.getName()}
        );
    }
}
