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

    @GetMapping("/bookRegisterPage")
    public String bookManagement(Model model) {
        model.addAttribute("book", new Book());
        return "book-register";
    }

    @GetMapping("/registerBook") //admin 계정만
    public String registerBook(@ModelAttribute("book") Book book, HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");
        if (id == null || !id.equals("Admin")) {
            return "redirect:user/loginError";
        }

        int result = this.bookService.insertBook(book);
        if (result != 0) {
            return "redirect:/book/bookRegisterPage";
        }

        return "redirect:/book/registerError";
    }

    @GetMapping("/bookMangementPage") //admin 계정만
    public String bookManagementPage(Model model, HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");
        if (id == null || !id.equals("Admin")) {
            return "redirect:../user/loginError";
        }
        List<Book> books = this.bookService.showAllBooks();
        model.addAttribute("books", books);

        return "book-management";
    }

    // Book 정소 수정 페이지
    @GetMapping("/editBookPage")
    public String editBookPage(@RequestParam("isbn") String isbn, Model model) {
        Book bookData = new Book();
        bookData.setIsbn(isbn);
        model.addAttribute("book", bookData);

        return "edit-book";
    }

    @GetMapping("/editBook")
    public String editBook(@ModelAttribute("book") Book book) {
        return "redirect:/book/bookMangementPage"; // 성공
//        return "redirect:/book/editBookPage"; // 실패
//        return "redirect:user/loginError"; // login 다시 해야함
    }

    @GetMapping("/deleteError")
    public String deleteError() {
        return "error/delete-book-error-handler";
    }

    @GetMapping("/delete")
    public String deleteBookData(@RequestParam("bookIsbn") String isbn) {
        int result = this.bookService.deleteBook(isbn);
        if (result == 0) {
            return "redirect:/book/deleteError";
        }

        return "redirect:/book/bookMangementPage";
    }
}
