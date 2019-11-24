package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Borrow;
import com.active.dbtermproject.repository.BorrowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private BorrowDao borrowDao;


    // 대출 기록 추가.
    // Borrow의 값중 isbn, title, customerId 필요
    public int insertBorrow(Borrow borrow) {
        return this.borrowDao.insert(borrow);
    }
}
