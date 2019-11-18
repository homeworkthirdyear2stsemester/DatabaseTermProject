package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.User;
import com.active.dbtermproject.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private UserDao userDao;

    public int insertService(User user) {
        return this.userDao.insert(user);
    }

    public List<String> getAllUserNames() {
        return this.userDao.getAllUserNames();
    }
}
