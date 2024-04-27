package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Data
public class Reservation {

    @EmbeddedId
    private IdReservation idReservation;


    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_table")
    private RestaurantTable restaurantTable;

    private LocalDateTime timestamp;
    private ReservationStatus status = ReservationStatus.CREATED;
    private TimeSlot timeSlot;


    public Reservation(Builder builder) {
        this.idReservation = builder.idReservation;
        this.customer = builder.customer;
        this.restaurantTable = builder.restaurantTable;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.timeSlot = builder.timeSlot;
    }

    public static class Builder{
        private IdReservation idReservation;
        private Customer customer;
        private RestaurantTable restaurantTable;
        private LocalDateTime timestamp;
        private ReservationStatus status;
        private TimeSlot timeSlot;


        public Builder setIdReservation(IdReservation idReservation) {
            this.idReservation = idReservation;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setRestaurantTable(RestaurantTable restaurantTable) {
            this.restaurantTable = restaurantTable;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setStatus(ReservationStatus status) {
            this.status = status;
            return this;
        }

        public Builder setTimeSlot(TimeSlot timeSlot) {
            this.timeSlot = timeSlot;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }

}
