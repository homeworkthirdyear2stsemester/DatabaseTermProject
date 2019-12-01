package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try{
            return this.bookDao.insert(book);
        } catch(Exception e){
            return 0;
        }
    }

    //도서 삭제

    /**
     * @param isbn : book.isbn
     * @return
     */
    public int deleteBook(String isbn) {
        try{
            return this.bookDao.delete(isbn);
        } catch(Exception e){
            return 0;
        }
    }

    //도서 정보 갱신

    /**
     * @param book : isbn,title,author,publisher,isBorrow,customerId 순서대로
     * @return
     */
    public int updateBook(Book book)
    {
        try{
            return this.bookDao.update(book);
        } catch(Exception e){
            return 0;
        }
    }

    //도서 검색

    /**
     * @param isbn : book.isbn
     * @return : 리턴 찾은 책 한개
     */
    public Book searchBookByIsbn(String isbn) {
        Optional<Book> bookOptional;
        try {
            bookOptional = this.bookDao.searchByIsbn(isbn);
        } catch (Exception e) {
            bookOptional = Optional.empty();
        }

        return bookOptional.orElse(null);
    }

    //도서 검색

    /**
     * @param bookTitle : book.title
     * @return : 리턴 찾은 책 여러개 가능
     */
    public List<Book> searchBookByTitle(String bookTitle) {
        try{
            return this.bookDao.searchByTitle(bookTitle);
        } catch(Exception e){
            return new ArrayList<Book>();
        }
    }

    //대출 가능 유무

    /**
     * @param book : book.isbn
     * @return :1이면 대여가능, 0이면 대여 불가능
     */
    public int isPossibleToBorrow(Book book) {
        try{
            return this.bookDao.checkIfBorrowed(book);
        } catch(Exception e){
            return 0;
        }
    }

    // isbn에 해당하는 책을 "빌림" 싱태로 바꿈. (is_borrow를 1로 갱신)

    /**
     * @param isbn : "빌림" 상태로 바꿀 isbn
     * @return : 성공하면 1, 실패하면 0
     */
    public int setBookToBorrowed(String isbn) {
        try{
            return this.bookDao.setBookToBorrowed(isbn);
        } catch(Exception e){
            return 0;
        }
    }

    //반납 승인(DB Book.is_borrow 0으로 갱신)

    /**
     * @param isbn : book.isbn
     * @return
     */
    public int allowToReturnBook(String isbn) {
        try{
            return this.bookDao.allowReturn(isbn);
        } catch(Exception e){
            return 0;
        }
    }

    //전체 도서 목록 조회

    /**
     * @return: 전제 도서 목록 리턴
     */
    public List<Book> showAllBooks() {
        try{
            return this.bookDao.getAllBooks();
        } catch(Exception e){
            return new ArrayList<Book>();
        }
    }
}
