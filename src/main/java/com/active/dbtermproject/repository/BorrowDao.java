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
    @Autowired
    private BookDao bookDao;

    public int insert(Borrow borrow) throws Exception {
        String customerId = borrow.getCustomerId();
        String customerType = customerDao.getTypeById(customerId);
        int dueDate = 10;
        if(customerType.equals("대학원생"))
            dueDate = 30;
        else if(customerType.equals("교직원"))
            dueDate = 60;

        // book 테이블의 is_borrow를 1로 갱신
        int success = this.bookDao.setBookToBorrowed(borrow.getIsbn());
        if(success==0)
            return 0;

        return this.jdbcTemplate.update(
                "INSERT INTO borrow " +
                        "(isbn, title, customer_id, borrow_date, return_date, is_return) " +
                        "VALUES (?, ?, ?, curdate(), adddate(curdate(), ?), ?)",
                borrow.getIsbn(), borrow.getTitle(), customerId, dueDate, 0);
    }

    // 반납 요청하는 함수(is_return을 1로 변경)
    public int setReturnTrue(Borrow borrow) throws Exception {
        return jdbcTemplate.update(
                "UPDATE borrow SET is_return=1 WHERE isbn=? AND customer_id=? AND is_return=0",
                borrow.getIsbn(), borrow.getCustomerId()
        );
    }


    // start <= x <= end 기간 사이의 Top10 대출 수 회원
    public List<Map<String, Object>> getTop10CustomerByPeriod(Date start, Date end) throws Exception {
        List<Map<String, Object>> top10List =
                this.jdbcTemplate.queryForList(
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

        // 타입을 "학부생", "대학원생", "교직원"으로 반환
        for(int i=0; i<top10List.size(); i++) {
            String newType = customerDao.convertType((String)top10List.get(i).get("type"));
            top10List.get(i).put("type", newType);
        }

        return top10List;
    }

    //회원의 대출 현황 조회
    public List<Borrow> getAllBorrowsById(String customerId) throws Exception{
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
    public int deleteReturnedBorrows() throws Exception {
        return this.jdbcTemplate.update(
                "DELETE FROM borrow WHERE is_return=1"
        );
    }

    // 반납 요청 승인 대기 목록 조회(Borrows)
    public List<Borrow> getBorrowsThatAwaitingApprovalForReturn() throws Exception {
        return this.jdbcTemplate.query(
                "SELECT borrow_number, isbn, title, customer_id, borrow_date, return_date, is_return " +
                        "FROM borrow natural join (SELECT isbn FROM book WHERE is_borrow=1) as b " +
                        "WHERE is_return=1;",
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
        );
    }
}
