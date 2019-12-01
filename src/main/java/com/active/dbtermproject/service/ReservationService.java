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
     *
     * @param reservation : reservation.customer_id,reservation.isbn,reservation.reserv_date
     * @return
     */
    public int insertReservation(Reservation reservation) {
        try{
            return this.reservationDao.insert(reservation);
        } catch(Exception e) {
            return 0;
        }
    }

    //예약 취소
    /**
     *
     * @param reservation : reservation.isbn
     * @return
     */
    public int cancleReservation(Reservation reservation) {
        try{
            return this.reservationDao.delete(reservation);
        } catch(Exception e) {
            return 0;
        }
    }

    //각 회원당 예약목록 조회
    /**
     *
     * @param customerId : user_id
     * @return
     */
    public List<Reservation> getReservationsByCustomerId(String customerId) {
        try{
            return this.reservationDao.getReservationsByCustomerId(customerId);
        } catch(Exception e) {
            return new ArrayList<Reservation>();
        }
    }

    //주어진 isbn을 예약한 인원 수
    /**
     *
     * @param reservation : reservation.isbn
     * @return
     */
    public int countReservationByIsbn(Reservation reservation){
        try{
            return this.reservationDao.countReservationByIsbn(reservation);
        } catch(Exception e) {
            return 0;
        }
    }

    //주어진 isbn이 예약된 목록들 반환
    /**
     *
     * @param reservation : reservation.isbn
     * @return
     */
    public List<Reservation> whoReservedPerIsbn(Reservation reservation){
        try{
            return this.reservationDao.getAllReservByIsbn(reservation);
        } catch(Exception e) {
            return new ArrayList<Reservation>();
        }
    }

    /**
     *
     * @param reservation : reservation.isbn
     * @return : 대출 가능한 날짜(YYYY-MM-DD)
     */
    public Date possibleBorrowDate(Reservation reservation){
        try{
            return this.reservationDao.availableDate(reservation);
        } catch(Exception e) {
            return null;
        }

    }
}
