package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.Customer;
import com.active.dbtermproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class CustomerController { // front와 backend 연결 다리 역할

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String check() {
        return "Welcome";
    }

    @GetMapping(path = "/getusernames")
    public List<String> getUserNames() {
        return this.customerService.getAllUserNames();
    }

    @PostMapping(path = "/insert")
    public int insertUser(@RequestBody Customer customer) {
        return this.customerService.insertService(customer);
    }

    @GetMapping("/test") // localhost/user/test
    public String test(Model model) {
        model.addAttribute("user", new Customer());

        return "test"; // 실제 호출될페이지 : /WEB-INF/jsp/test.jsp
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/custmerSave")
    public String customerSave(@ModelAttribute("customer") Customer customer) {
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
