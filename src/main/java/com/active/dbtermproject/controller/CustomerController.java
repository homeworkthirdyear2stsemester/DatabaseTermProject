package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.Borrow;
import com.active.dbtermproject.domain.Customer;
import com.active.dbtermproject.domain.Reservation;
import com.active.dbtermproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class CustomerController { // front와 backend 연결 다리 역할

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/mainUserPage")
    public String mainUserPage(Model model) {
        Random random = new Random(200);
        List<Reservation> reservationList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            reservationList.add(Reservation.builder()
                    .isbn(Integer.toString(random.nextInt()))
                    .customerId(Integer.toString(random.nextInt()))
                    .reservDate(new Date(index))
                    .build());
        }
        List<Borrow> borrowList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            borrowList.add(Borrow.builder()
                    .isbn(Integer.toString(random.nextInt()))
                    .title("12312")
                    .borrowDate(new Date(123))
                    .returnDate(new Date(123))
                    .build());
        }
        model.addAttribute("borrows", borrowList);
        model.addAttribute("reservations", reservationList);

        return "main-user";
    }

    @PostMapping("/custmerSave")
    public String customerSave(@ModelAttribute("customer") Customer customer) {
        // return "redirect:/user/register"; // 실패
        return "redirect:/user/login"; // 성공
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute("customer") Customer customer) {
        /**
         * db에서 user정보 있는지 판별
         */
//        return "redirect:/user/mainAdminPage"; admin 계정
//        return "redirect:/user/mainUserPage"; 성공시
        return "redirect:/user/login"; // 실패
    }
}
