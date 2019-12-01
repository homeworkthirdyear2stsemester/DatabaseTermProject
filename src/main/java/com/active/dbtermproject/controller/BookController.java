package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.Book;
import com.active.dbtermproject.domain.Borrow;
import com.active.dbtermproject.domain.Reservation;
import com.active.dbtermproject.service.BookService;
import com.active.dbtermproject.service.BorrowService;
import com.active.dbtermproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController { // front와 backend 연결 다리 역할

    @Autowired
    private BookService bookService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private BorrowService borrowService;

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
            return "redirect:../user/loginError";
        }

        List<Book> books;
        if (type.equals("isbn")) {
            Book resultBook = this.bookService.searchBookByIsbn(data);
            books = new ArrayList<>();
            if (resultBook != null) {
                books.add(resultBook);
            }
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
            return "redirect:../user/loginError";
        }

        int result = this.bookService.insertBook(book);
        if (result != 0) {
            return "redirect:/book/bookRegisterPage";
        }

        return "redirect:/book/registerError";
    }

    @GetMapping("/bookManagementPage") //admin 계정만
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
    public String editBookPage(@RequestParam("bookIsbn") String isbn, Model model) {
        Book bookData = new Book();
        bookData.setIsbn(isbn);
        model.addAttribute("book", bookData);

        return "edit-book";
    }

    @GetMapping("/editBook")
    public String editBook(@ModelAttribute("book") Book book, HttpSession httpSession) {
        Object idData = httpSession.getAttribute("id");

        if (idData == null || !(idData).equals("Admin")) {
            return "redirect:../user/loginError"; // login 다시 해야함
        }

        int result = this.bookService.updateBook(book);
        if (result == 0) {
            return "redirect:/book/editBookPage"; // 실패
        }

        return "redirect:/book/bookManagementPage"; // 성공
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

        return "redirect:/book/bookManagementPage";
    }

    @GetMapping("/cancealReservationPage")
    public String cancealPage(@RequestParam("bookIsbn") String isbn, HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");
        if (id == null) {
            return "redirect:../user/loginError";
        }
        int result = this.reservationService.cancleReservation(Reservation.builder()
                .isbn(isbn)
                .customerId((String) id)
                .build());

        if (result == 0) {
            return "error/delete-error-reservation-handler";
        }

        return "redirect:../user/mainUserPage";
    }

    @GetMapping("/authorizeReturn")
    public String authorizeReturnPage(Model model) {
        List<Borrow> authorizedReturnList = this.borrowService.getBorrowsThatAwaitingApprovalForReturn();
        model.addAttribute("authorizedReturnList", authorizedReturnList);

        return "authorizeReturn";
    }

    @GetMapping("/returnBookError")
    public String returnBookError() {
        return "error/return-book-error-handler";
    }

    @GetMapping("/comfirmReturnBorrow")
    public String comfirmReturnBorrow(@RequestParam("bookIsbn") String isbn) {
        int result = this.bookService.allowToReturnBook(isbn);
        if (result == 0) {
            return "redirect:/book/returnBookError";
        }

        return "redirect:/book/authorizeReturn";
    }

    @GetMapping("/topTenPage")
    public String topTenPage(Model model) {
        Date endDate = new Date(new java.util.Date().getTime());
        Date beforeDate = this.calculateDate(endDate);
        List<Map<String, Object>> topTenData = this.borrowService.getTop10CustomerByPeriod(beforeDate, endDate);
        model.addAttribute("topTenData", topTenData);

        return "top-ten";
    }

    private Date calculateDate(Date nowDate) {
        int days = 30;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(calendar.DATE, -days);

        return new Date(calendar.getTimeInMillis());
    }

    @GetMapping("/waitingForReturn")
    public String waitingForReturn(@RequestParam("borrowNumber") int borrowNumber) {
        if (this.borrowService.requestReturn(borrowNumber) != 0) {
            return "redirect:../user/mainUserPage"; // 성공
        }

        return "redirect:../user/mainUserPage"; // error page연결 하기
    }

    @GetMapping("/returnRequestErrorHandler")
    public String returnRequestErrorHandler() {
        return "error/request-return-error-handler";
    }

    @GetMapping("/makeBorrow")
    public String borrowBook(@RequestParam("bookIsbn") String isbn,
                             @RequestParam("bookTitle") String title,
                             HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");
        if (id == null) {
            return "redirect:../user/loginError";
        }

        int result = this.borrowService.insertBorrow(Borrow.builder().title(title).isbn(isbn).customerId((String) id).build());
        if (result != 0) {
            return "redirect:bookSearchPage";
        }

        return "redirect:borrowErrorHandlerPage"; // error page 작성
    }
    @GetMapping("/borrowErrorHandlerPage")
    public String borrowErrorHandlerPage(){
        return "error/borrow-error-handler";
    }
}
