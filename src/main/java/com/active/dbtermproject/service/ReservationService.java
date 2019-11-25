package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Reservation;
import com.active.dbtermproject.repository.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    //예약 추가
    /**
     *
     * @param reservation : reservation.customer_id,reservation.isbn,reservation.reserv_date
     * @return
     */
    public int insertReservation(Reservation reservation) { return this.reservationDao.insert(reservation);}

    //예약 취소
    /**
     *
     * @param reservation : reservation.isbn
     * @return
     */
    public int cancleReservation(Reservation reservation) {return this.reservationDao.delete(reservation);}

    //각 회원당 예약목록 조회
    /**
     *
     * @param reservation : user_id
     * @return
     */
    public List<Reservation> showAllReservation(Reservation reservation) {return this.reservationDao.findAll(reservation);}

    //주어진 isbn을 예약한 인원 수
    /**
     *
     * @param reservation : reservation.isbn
     * @return
     */
    public int howManyReservationPerIsbn(Reservation reservation){return this.reservationDao.howManyPerIsbn(reservation);}

    //주어진 isbn이 예약된 목록들 반환
    /**
     *
     * @param reservation : reservation.isbn
     * @return
     */
    public List<Reservation> whoReservedPerIsbn(Reservation reservation){return this.reservationDao.getAllReservByIsbn(reservation);}
}
