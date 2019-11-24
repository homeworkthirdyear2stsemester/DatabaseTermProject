package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.*;
import com.active.dbtermproject.repository.BorrowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BorrowService { // 예외처리 및 데이터 가공 등등을 해야함
    @Autowired
    private BorrowDao borrowDao;

    // 대출 기록 추가
    /**
     *
     * @param borrow : borrow.isbn, borrow.title, borrow.customerId
     * @return : 성공시 1
     */
    public int insertBorrow(Borrow borrow) {
        return this.borrowDao.insert(borrow);
    }

    //도서 반납 요청(borrow.isReturn을 1로 변경)
    /**
     * @param borrow : borrow.isbn, borrow.customerId
     * @return : 성공시 1
     */
    public int requestReturn(Borrow borrow) {
        return this.borrowDao.setReturnTrue(borrow);
    }

    // 일정 기간 동안 대출을 많이한 Top 10 회원 검색
    /**
     * @param start : Date
     * @param end : Date
     * @return : start~end 사이에 대출을 가장 많이 한 Top 10 Customer List
     */
    public List<Customer> getTop10CustomerByPeriod(Date start, Date end) {
        return null;
    }
}
