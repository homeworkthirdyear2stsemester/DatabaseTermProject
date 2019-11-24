package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private BookDao bookDao;

    public int insertBook(Book book) {
        return this.bookDao.insert(book);
    }

    public int deleteBook(Book book) {
        return this.bookDao.delete(book);
    }
}
