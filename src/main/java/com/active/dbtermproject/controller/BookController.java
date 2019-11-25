package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController { // front와 backend 연결 다리 역할

    @Autowired
    private BookService bookService;

    @GetMapping("/bookSearchPage")
    public String bookSearch() {
        return "search";
    }

    @GetMapping("/registerError")
    public String registerError() {
        return "error/register-error-handler";
    }

    @GetMapping("/bookSearch")
    public String bookSearch(@RequestParam("type") String type
            , @RequestParam("data") String data
            , Model model, HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");

        if (id == null) {
            return "redirect:error/login-error-handler";
        }

        List<Book> books;
        if (type.equals("isbn")) {
            books = new ArrayList<>();
            books.add(this.bookService.searchBookByIsbn(data));
        } else {
            books = this.bookService.searchBookByTitle(data);
        }
        model.addAttribute("books", books);

        return "search-result";
    }

    @GetMapping("/bookManagementPage")
    public String bookManagement(Model model) {
        model.addAttribute("book", new Book());
        return "book-management";
    }

    @GetMapping("/registerBook")
    public String registerBook(@ModelAttribute("book") Book book) {
        int result = this.bookService.insertBook(book);
        if (result != 0) {
            return "redirect:/book/bookManagementPage";
        }

        return "redirect:/book/registerError";
    }
}
