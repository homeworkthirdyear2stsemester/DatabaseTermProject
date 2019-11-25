package com.active.dbtermproject.service;

import com.active.dbtermproject.domain.Reservation;
import com.active.dbtermproject.repository.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
