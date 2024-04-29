package com.digitalflooding.archie.controller;

import com.digitalflooding.archie.dto.TableRestaurantDto;
import com.digitalflooding.archie.entity.IdReservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class ReservationController {

    public ResponseEntity<> deleteReservation(LocalDate reservationDate, LocalTime reservationTime, TableRestaurantDto table) {
        IdReservation idReservation = new IdReservation.Builder()
                .setIdTable(table.getId())
                .setDate(reservationDate)
                .setTime(reservationTime)
                .build();
    }
}
