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
    public int delete(String bookIsbn) {
        return this.jdbcTemplate.update(
                "delete from teamproject.book where isbn=?",
                bookIsbn
        );
    }

    // 도서 정보 수정
    public int update(Book book) {
        return this.jdbcTemplate.update(
                "update teamproject.book set book.title=?,author=?,publisher=?,is_borrow=?,customer_id=? where book.isbn=?;",
                book.getTitle(), book.getAuthor(), book.getPublisher(), book.getIsBorrow(), book.getCustomerId(), book.getIsbn()
        );
    }

    // 도서 ISBN으로 검색
    public Optional<Book> searchByIsbn(String isbn) {
        return this.jdbcTemplate.queryForObject(
                "select * from teamproject.book where isbn=?",
                new Object[]{isbn},
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
    public List<Book> searchByTitle(String bookTitle) {
        return this.jdbcTemplate.query(
                "select * from book where title=" + "'" + bookTitle + "'",//sql문
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

    //isbn으로 대출가능 여부 확인
    public int checkIfBorrowed(Book book) {
        Optional<Book> book1 = this.searchByIsbn(book.getIsbn());//입력받은 isbn으로 책 정보 가져옴
        if (book1.get().getIsBorrow() == 0) {//만약 누가 빌려가지 않았다면
            return 1;//1리턴
        } else {//누가 빌려갔다면
            return 0;//0리턴
        }
    }

    //입력받은 isbn으로 is_borrow=1 갱신
    public int setBookToBorrowed(String isbn) {
        return this.jdbcTemplate.update(
                "update teamproject.book set is_borrow=1 where book.isbn=?;",
                isbn
        );
    }

    //입력받은 isbn으로 is_borrow=0 갱신
    public int allowReturn(String isbn) {
        return this.jdbcTemplate.update(
                "update teamproject.book set is_borrow=0 where book.isbn=?;",
                isbn
        );
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query(
                "select * from teamproject.book",
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

