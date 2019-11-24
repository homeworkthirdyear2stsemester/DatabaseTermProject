package com.active.dbtermproject.controller;


import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private BookService bookService;

    @PostMapping("/insert")
    public int insertBook(@RequestBody Book book) {
        return this.bookService.insertBook(book);
    }
}
