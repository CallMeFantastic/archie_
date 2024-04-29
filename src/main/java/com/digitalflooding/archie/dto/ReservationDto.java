package com.digitalflooding.archie.dto;

import com.digitalflooding.archie.entity.*;
import java.time.LocalDateTime;

public class ReservationDto {

    private IdReservation idReservation;
    private Customer customerDto;
    private TableRestaurant tableRestaurant;
    private LocalDateTime timestamp;
    private ReservationStatus status = ReservationStatus.CREATED;
    private TimeSlot timeSlot;


    public ReservationDto(Builder builder) {
        this.idReservation = builder.idReservation;
        this.customerDto = builder.customerDto;
        this.tableRestaurant = builder.tableRestaurant;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.timeSlot = builder.timeSlot;
    }

    public static class Builder{
        private IdReservation idReservation;
        private Customer customerDto;
        private TableRestaurant tableRestaurant;
        private LocalDateTime timestamp;
        private ReservationStatus status;
        private TimeSlot timeSlot;


        public Builder setIdReservation(IdReservation idReservation) {
            this.idReservation = idReservation;
            return this;
        }

        public Builder setCustomer(Customer customerDto) {
            this.customerDto = customerDto;
            return this;
        }

        public Builder setTableRestaurant(TableRestaurant tableRestaurant) {
            this.tableRestaurant = tableRestaurant;
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

        public ReservationDto build(){
            return new ReservationDto(this);
        }
    }
}
