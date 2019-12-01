package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.Borrow;
import com.active.dbtermproject.domain.Customer;
import com.active.dbtermproject.domain.Reservation;
import com.active.dbtermproject.domain.ReservationAndIsBorrow;
import com.active.dbtermproject.service.BorrowService;
import com.active.dbtermproject.service.CustomerService;
import com.active.dbtermproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class CustomerController { // front와 backend 연결 다리 역할

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/deleteError")
    public String errorHandler() {
        return "error/delete-error-handler";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }

    @GetMapping("/loginError")
    public String loginError() {
        return "error/login-error-handler";
    }

    @GetMapping("/mainAdminPage")
    public String mainAdminPage() {
        return "main-admin";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new Customer());

        return "register";
    }

    @GetMapping("/editProfile")
    public String editProfilePage(Model model) {
        model.addAttribute("customer", new Customer());
        return "edit-profile";
    }

    @GetMapping("/mainUserPage") // 수정해야함
    public String mainUserPage(Model model, HttpSession httpSession) {
        Object id = httpSession.getAttribute("id");
        if (id == null) {
            return "redirect:/user/login";
        } else if (id.equals("Admin")) {
            return "redirect:/user/mainAdminPage";
        } // login 예외

        List<ReservationAndIsBorrow> reservationList = this.reservationService.getReservationsByCustomerId((String) id);

        List<Borrow> borrowList = this.borrowService.getAllBorrowsById((String) id);
        if (borrowList == null) {
            borrowList = new ArrayList<>();
        }

        if (reservationList == null) {
            reservationList = new ArrayList<>();
        }

        model.addAttribute("borrows", borrowList);
        model.addAttribute("reservations", reservationList);

        return "main-user";
    }

    @PostMapping("/customerSave")
    public String customerSave(@ModelAttribute("customer") Customer customer) {
        int insertResult = this.customerService.insertService(customer);
        if (insertResult == 0) {
            return "redirect:/user/register"; // 실패
        }

        return "redirect:/user/login"; // 성공
    }

    @GetMapping("/deleteUserData")
    public String deleteUserData(HttpSession httpSession) {
        Object customerId = httpSession.getAttribute("id");
        if (customerId != null
                && this.customerService.deleteService((String) customerId) == 1) {
            httpSession.removeAttribute("id");
            return "redirect:/user/login"; // 회원탈퇴 성공
        }

        return "redirect:/user/deleteError";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute("customer") Customer customer,
                             HttpSession httpSession) {
        Customer databaseCustomer = this.customerService.getCustomerByIdService(customer.getId());
        if(databaseCustomer == null){
            return "redirect:/user/login";//입력된 ID가 존재하지 않을 경우
        }
        if (databaseCustomer.getId().equals(customer.getId()) &&
                databaseCustomer.getPassword().equals(customer.getPassword())) {
            httpSession.setAttribute("id", customer.getId());
            if (customer.getId().equals("Admin")) {
                return "redirect:/user/mainAdminPage"; //admin 계정
            }

            return "redirect:/user/mainUserPage"; // 성공시
        }
        return "redirect:/user/login"; // 실패
    }

    @PostMapping("/changeCustomerData")
    public String changeCustomerData(@ModelAttribute("customer") Customer customer, HttpSession httpSession) {

        Object id = httpSession.getAttribute("id");
        if (id == null) {
            return "redirect:/user/loginError"; // login 안되어있을 경우
        }

        try {
            int result = this.customerService.updateService((String) id, customer);
            if (result != 0) {
                if (id.equals("Admin")) {
                    return "redirect:/user/mainAdminPage"; //admin 계정
                }
                httpSession.removeAttribute("id"); // session 제거

                return "redirect:/user/login"; // 성공
            }
        } catch (Exception e) {
            return "redirect:/user/edit-profile";
        }

        return "redirect:/user/editProfile";
    }

    @GetMapping("/logoutPage")
    public String logOut(HttpSession httpSession) {
        if (httpSession.getAttribute("id") != null) {
            httpSession.removeAttribute("id");
        }

        return "redirect:/user/login";
    }
}
