package com.digitalflooding.archie.dto;

import com.digitalflooding.archie.entity.Reservation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class TableRestaurantDto {

    private Integer id; //table number
    private Map<LocalDateTime, Reservation> reservations;
    private Integer seats;

    public TableRestaurantDto(Builder builder) {
        this.id = builder.id;
        this.reservations = builder.reservations;
        this.seats = builder.seats;
    }

    public static class Builder{
        private Integer id; //table number
        private Map<LocalDateTime, Reservation> reservations;
        private Integer seats;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setReservations(Map<LocalDateTime, Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public Builder setSeats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public TableRestaurantDto build(){
            return new TableRestaurantDto(this);
        }

    }
}
