package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public class BorrowDao { // db접근 함수들

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerDao customerDao;

    public int insert(Borrow borrow) {
        String customerId = borrow.getCustomerId();
        String customerType = customerDao.getTypeById(customerId);
        int dueDate = 10;
        if(customerType.equals("30"))
            dueDate = 30;
        else if(customerType.equals("60"))
            dueDate = 60;

        return this.jdbcTemplate.update(
                "INSERT INTO borrow " +
                        "(isbn, title, customer_id, borrow_date, return_date, is_return) " +
                        "VALUES (?, ?, ?, curdate(), adddate(curdate(), ?), ?)",
                borrow.getIsbn(), borrow.getTitle(), customerId, dueDate, 0);
    }

    // is_return을 1로 변경하는 함수
    public int setReturnTrue(Borrow borrow) {
        return jdbcTemplate.update(
                "UPDATE borrow SET is_return=1 WHERE isbn=? AND customer_id=? AND is_return=0",
                borrow.getIsbn(), borrow.getCustomerId()
        );
    }

    // start <= x <= end 기간 사이의 Top10 대출 수 회원
    public List<Map<String, Object>> getTop10CustomerByPeriod(Date start, Date end) {
        return this.jdbcTemplate.queryForList(
                "SELECT id, password, email, name, phone_number, type, cnt_borrow " +
                    "FROM customer c, " +
                        "(SELECT customer_id, count(*) as cnt_borrow " +
                        "FROM borrow " +
                        "WHERE borrow_date BETWEEN ? AND ? " +
                        "GROUP BY customer_id " +
                        "order by cnt_borrow desc) as b " +
                    "WHERE id = customer_id"
                , start, end
        );
    }

    //회원의 대출 현황 조회
    public List<Borrow> getAllBorrowsById(String customerId) {
        return this.jdbcTemplate.query(
                "SELECT * FROM borrow WHERE customer_id=? AND is_return=0",
                (rs, rowNum) ->
                        Borrow.builder()
                                .borrowNumber(rs.getInt("borrow_number"))
                                .isbn(rs.getString("isbn"))
                                .title(rs.getString("title"))
                                .customerId(rs.getString("customer_id"))
                                .borrowDate(rs.getDate("borrow_date"))
                                .returnDate(rs.getDate("return_date"))
                                .isReturn(rs.getInt("is_return"))
                                .build()
                , customerId
                );
    }

    // 반납된 대출 기록 삭제
    public int deleteReturnedBorrows() {
        return this.jdbcTemplate.update(
                "DELETE FROM borrow WHERE is_return=1"
        );
    }
}
