package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private BookDao bookDao;

    //도서 등록
    /**
     *
     * @param book: isbn,title,author,publisher,isBorrow,customerId
     * @return
     */
    public int insertBook(Book book) {
        return this.bookDao.insert(book);
    }

    //도서 삭제
    /**
     *
     * @param book : book.isbn
     * @return
     */
    public int deleteBook(Book book) {
        return this.bookDao.delete(book);
    }

    //도서 정보 갱신
    /**
     *
     * @param book : isbn,title,author,publisher,isBorrow,customerId 순서대로 갱신
     * @return
     */
    public int updateBook(Book book){ return this.bookDao.update(book); }

    //도서 검색
    /**
     *
     * @param book : book.isbn
     * @return : 리턴 찾은 책 한개
     */
    public Optional<Book> searchBookByIsbn(Book book) {
        return this.bookDao.searchByIsbn(book);
    }

    //도서 검색
    /**
     *
     * @param book : book.title
     * @return : 리턴 찾은 책 여러개 가능
     */
    public List<Book> searchBookByTitle(Book book) {
        return this.bookDao.searchByTitle(book);
    }

    /**
     *
     * @param book : isbn
     * @return :1이면 대여가능, 0이면 대여 불가능
     */
    public int isPossibleToBorrow(Book book){return this.bookDao.checkIfBorrowed(book);}


}
