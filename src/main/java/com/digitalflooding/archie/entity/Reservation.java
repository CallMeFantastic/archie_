package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Customer customer;

    private Calendar reservationDate;

    private Calendar arrivalDate;

    @ManyToOne
    private RestaurantTable restaurantTable;

    private ReservationStatus status = ReservationStatus.CREATED;
}
