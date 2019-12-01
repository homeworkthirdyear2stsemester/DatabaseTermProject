package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Reservation;
import com.active.dbtermproject.repository.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;


    //예약 추가

    /**
     * @param customerId : customer_id
     * @param isbn       : isbn
     * @return
     */
    public int insertReservation(String customerId, String isbn) {
        try {
            return this.reservationDao.insert(customerId, isbn);
        } catch (Exception e) {
            return 0;
        }
    }

    //예약 취소

    /**
     * @param reservation : reservation.isbn
     * @return
     */
    public int cancleReservation(Reservation reservation) {
        try {
            return this.reservationDao.delete(reservation);
        } catch (Exception e) {
            return 0;
        }
    }

    //각 회원당 예약목록 조회

    /**
     * @param customerId : user_id
     * @return
     */
    public List<Reservation> getReservationsByCustomerId(String customerId) {
        try {
            return this.reservationDao.getReservationsByCustomerId(customerId);
        } catch (Exception e) {
            return new ArrayList<Reservation>();
        }
    }

    //주어진 isbn을 예약한 인원 수

    /**
     * @param reservation : reservation.isbn
     * @return
     */
    public int countReservationByIsbn(Reservation reservation) {
        try {
            return this.reservationDao.countReservationByIsbn(reservation);
        } catch (Exception e) {
            return 0;
        }
    }

    //주어진 isbn이 예약된 목록들 반환

    /**
     * @param reservation : reservation.isbn
     * @return
     */
    public List<Reservation> whoReservedPerIsbn(Reservation reservation) {
        try {
            return this.reservationDao.getAllReservByIsbn(reservation);
        } catch (Exception e) {
            return new ArrayList<Reservation>();
        }
    }

    /**
     * @param reservation : reservation.isbn
     * @return : 대출 가능한 날짜(YYYY-MM-DD)
     */
    public Date possibleBorrowDate(Reservation reservation) {
        try {
            return this.reservationDao.availableDate(reservation);
        } catch (Exception e) {
            return null;
        }
    }

    //이미 예약되어 있는지 확인

//    /**
//     * @param reservation:reservation.isbn
//     * @return :예약자가 있으면 1,없으면 0 리턴
//     */
//    public int isAreadyReserv(Reservation reservation) {
//        try {
//            return this.reservationDao.isAreadyReserv(reservation);
//        } catch (Exception e) {
//            return 0;
//        }
//    }

}
