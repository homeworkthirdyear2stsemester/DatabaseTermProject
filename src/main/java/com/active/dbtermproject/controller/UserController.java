package com.active.dbtermproject.controller;

import com.active.dbtermproject.domain.User;
import com.active.dbtermproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController { // front와 backend 연결 다리 역할

    @Autowired
    private UserService userService;

    @GetMapping
    public String check() {
        return "Welcome";
    }

    @GetMapping(path = "/getusernames")
    public List<String> getUserNames() {
        return this.userService.getAllUserNames();
    }

    @PostMapping(path = "/insert")
    public int insertUser(@RequestBody User user) {
        return this.userService.insertService(user);
    }
}
