package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    public int setReturnTrue(Borrow borrow) {
        return jdbcTemplate.update(
                "UPDATE borrow SET is_return=1 WHERE isbn=? AND customer_id=? AND is_return=0",
                borrow.getIsbn(), borrow.getCustomerId()
        );
    }
}
