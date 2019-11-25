package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 예약 추가
    public int insert(Reservation reservation) {
        return this.jdbcTemplate.update(
                "insert into teamproject.reservation(customer_id,isbn,reserv_date) values(?,?,?)",
                new Object[]{reservation.getCustomerId(),reservation.getIsbn(),reservation.getReservDate()}
        );
    }

}
