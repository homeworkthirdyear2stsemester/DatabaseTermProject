package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    // 예약 삭제
    public int delete(Reservation reservation) {
        return this.jdbcTemplate.update(
                "delete from teamproject.reservation where isbn=?",
                reservation.getIsbn()
        );
    }

    //회원당 예약 목록 조회
    public List<Reservation> findAll(Reservation reservation) {
        return jdbcTemplate.query(
                "select * from teamproject.reservation where customer_id=?",
                (rs, rowNum) ->
                        Reservation.builder()
                                .customerId(rs.getString("customer_id"))
                                .isbn(rs.getString("isbn"))
                                .reservDate(rs.getDate("reserv_date"))
                                .build()
                , reservation.getCustomerId()
        );
    }

    // "isbn"을 예약한 목록 반환
    public List<Reservation> getAllReservByIsbn(Reservation reservation) {
        return this.jdbcTemplate.query(
                "SELECT * FROM reservation WHERE isbn=?",
                (rs, rowNum) -> Reservation.builder()
                        .customerId(rs.getString("customer_id"))
                        .isbn(rs.getString("isbn"))
                        .reservDate(rs.getDate("reserv_date"))
                        .build(),
                reservation.getIsbn());
    }

    //위에서 작성한 함수를 호출해 isbn이 예약한 리스트 가져와 사이즈 리턴
    public int howManyPerIsbn(Reservation reservation){
        List<Reservation> listOfReservation=getAllReservByIsbn(reservation);
        return listOfReservation.size();
    }

}
