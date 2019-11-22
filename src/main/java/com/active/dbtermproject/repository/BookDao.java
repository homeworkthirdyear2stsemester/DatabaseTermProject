package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao { // db접근 함수들

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 도서 등록
    public int insert(Book book) {
        return -1;
    }

    // 도서 삭제
    public int delete() {
        return -1;
    }

    // 도서 정보 수정
    public int update() {
        return -1;
    }
}
