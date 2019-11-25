package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.*;
import com.active.dbtermproject.repository.BorrowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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
     * @param start : Date (yyyy-mm-dd)
     * @param end : Date (yyyy-mm-dd)
     * @return : start~end 사이에 대출을 가장 많이 한 Top 10 Customer List
     *           - 인덱스 순서가 곧 순위
     *           - 마지막 값이 해당 회원의 대출 수
     */
    public List<Map<String, Object>> getTop10CustomerByPeriod(Date start, Date end) {
        return borrowDao.getTop10CustomerByPeriod(start, end);
    }

    //회원의 대출 현황 조회
    /**
     *
     * @param customerId : 회원 id
     * @return : 회원의 대출 현황 List
     */
    public List<Borrow> getAllBorrowsById(String customerId) {
        return borrowDao.getAllBorrowsById(customerId);
    }

    // 반납된 대출 기록 삭제
    /**
     *
     * @return : 삭제된 대출 기록 수
     */
    public int deleteReturnedBorrows() {
        return borrowDao.deleteReturnedBorrows();
    }
}
