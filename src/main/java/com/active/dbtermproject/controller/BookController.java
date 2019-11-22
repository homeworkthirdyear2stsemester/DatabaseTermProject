package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController { // front와 backend 연결 다리 역할

    @Autowired
    private BookService bookService;

    @GetMapping
    public String check() {
        return "Welcome";
    }
}
