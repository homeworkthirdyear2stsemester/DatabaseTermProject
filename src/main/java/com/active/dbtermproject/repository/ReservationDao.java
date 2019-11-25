package com.active.dbtermproject.repository;

import com.active.dbtermproject.domain.Borrow;
import com.active.dbtermproject.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ReservationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CustomerDao customerDao;

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
                "delete from teamproject.reservation where isbn=? and user_id=?",
                reservation.getIsbn(), reservation.getCustomerId()
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

    public Date availableDate(Reservation reservation) {
        Optional<Borrow> temp = jdbcTemplate.queryForObject(
                "select * from teamproject.borrow where isbn= ?",
                new Object[]{reservation.getIsbn()},
                (rs, rowNum) ->
                        Optional.of(Borrow.builder()
                                .borrowNumber(rs.getInt("borrow_number"))
                                .isbn(rs.getString("isbn"))
                                .title(rs.getString("title"))
                                .customerId(rs.getString("customer_id"))
                                .borrowDate(rs.getDate("borrow_date"))
                                .returnDate(rs.getDate("return_date"))
                                .isReturn(rs.getInt("is_return"))
                                .build())
        );
        Borrow resulBorrow = temp.orElse(null);
        Date reuturnDate = resulBorrow.getReturnDate();//해당 isbn의 return_date가져오기
        return calculateDate(reuturnDate,reservation);
    }

    private Date calculateDate(Date inputDate,Reservation reservation) {
        String type;
        int plusDate=0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDate);

        List<Map<String, Object>> countPerType =
                this.jdbcTemplate.queryForList(
                        "SELECT type, SUM(cnt) " +
                                "FROM customer c, (SELECT customer_id, count(*) as cnt " +
                                "FROM reservation )" +
                                "WHERE isbn=?");
        List<Reservation> listOfReservation = getAllReservByIsbn(reservation);//해당 isbn을 예약한 목록 가져옴
        for (int i = 0; i < listOfReservation.size(); i++) {//리스트 사이즈만큼 반복
            type = customerDao.getTypeById(listOfReservation.get(i).getCustomerId());//리스트 원소마다 타입 가져옴
            if (type.equals("30")) {//타입마다 다른 일수 합치기
                plusDate+=30;
            } else if (type.equals("60")) {
                plusDate+=60;
            } else {
                plusDate+=10;
            }
        }
        cal.add(cal.DATE, plusDate);
        return new Date(cal.getTimeInMillis());
    }

}
