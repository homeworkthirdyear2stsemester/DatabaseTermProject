package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                new Object[]{book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getIsBorrow(), book.getCustomerId()}
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

    // 도서 ISBN으로 검색
    public Optional<Book> searchByIsbn(Book book) {
        return this.jdbcTemplate.queryForObject(
                "select * from teamproject.book where isbn=?",
                new Object[]{book.getIsbn()},
                (rs, rowNum) ->
                        Optional.of(Book.builder()
                                .isbn(rs.getString("isbn"))
                                .title(rs.getString("title"))
                                .author(rs.getString("author"))
                                .publisher(rs.getString("publisher"))
                                .isBorrow(rs.getInt("is_borrow"))
                                .customerId(rs.getString("customer_id"))
                                .build())
        );
    }

    // 도서 TITLE로 검색
    public List<Book> searchByTitle(Book book) {
        return this.jdbcTemplate.query(
                "select * from book where title="+"'"+book.getTitle()+"'",
                (rs, rowNum) ->
                                Book.builder()
                                .isbn(rs.getString("isbn"))
                                .title(rs.getString("title"))
                                .author(rs.getString("author"))
                                .publisher(rs.getString("publisher"))
                                .isBorrow(rs.getInt("is_borrow"))
                                .customerId(rs.getString("customer_id"))
                                .build()
        );
    }


}

