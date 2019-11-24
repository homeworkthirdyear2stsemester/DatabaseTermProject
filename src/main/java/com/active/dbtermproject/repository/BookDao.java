package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao { // db접근 함수들

//        return this.jdbcTemplate.update(
//                "insert into user(id, name) values(?, ?)",
//                new Object[]{user.getId(), user.getName()}
//        );

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 도서 등록
    public int insert(Book book) {
        return this.jdbcTemplate.update(
               "insert into teamproject.book(isbn, title,author,publisher,is_borrow,customer_id) values(?,?,?,?,?,?)",
               new Object[]{book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getIsBorrow(),book.getCustomerId()}
         );
    }

    // 도서 삭제
    public int delete(Book book) {
        return this.jdbcTemplate.update(
                "delete from teamproject.book where isbn=?",
                book.getIsbn()
        );
    }

    // 도서 정보 수정
    public int update(Book book) {


        return -1;
    }
}
