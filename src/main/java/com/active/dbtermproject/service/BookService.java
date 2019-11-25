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
     * @param book: isbn,title,author,publisher,isBorrow,customerId
     * @return
     */
    public int insertBook(Book book) {
        return this.bookDao.insert(book);
    }

    //도서 삭제

    /**
     * @param isbn : book.isbn
     * @return
     */
    public int deleteBook(String isbn) {
        return this.bookDao.delete(isbn);
    }

    //도서 정보 갱신

    /**
     * @param book : isbn,title,author,publisher,isBorrow,customerId 순서대로
     * @return
     */
    public int updateBook(Book book) {
        return this.bookDao.update(book);
    }

    //도서 검색

    /**
     * @param isbn : book.isbn
     * @return : 리턴 찾은 책 한개
     */
    public Book searchBookByIsbn(String isbn) {
        Optional<Book> bookOptional = this.bookDao.searchByIsbn(isbn);

        return bookOptional.orElse(null);
    }

    //도서 검색

    /**
     * @param bookTitle : book.title
     * @return : 리턴 찾은 책 여러개 가능
     */
    public List<Book> searchBookByTitle(String bookTitle) {
        return this.bookDao.searchByTitle(bookTitle);
    }

    //대출 가능 유무

    /**
     * @param book : book.isbn
     * @return :1이면 대여가능, 0이면 대여 불가능
     */
    public int isPossibleToBorrow(Book book) {
        return this.bookDao.checkIfBorrowed(book);
    }

    //반납 승인(DB Book.is_borrow 0으로 갱신)

    /**
     * @param isbn : book.isbn
     * @return
     */
    public int allowToReturnBook(String isbn) {
        return this.bookDao.allowReturn(isbn);
    }

    //전체 도서 목록 조회

    /**
     * @return: 전제 도서 목록 리턴
     */
    public List<Book> showAllBooks() {
        return this.bookDao.getAllBooks();
    }
}
