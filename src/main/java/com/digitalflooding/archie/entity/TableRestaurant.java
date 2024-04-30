package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
public class TableRestaurant {
    @Id
    @NotNull
    private Integer id; //table number

    @OneToMany
    private Map<LocalDateTime, Reservation> reservations;

    @NotNull
    private Integer seats;

    @NotNull
    private TableStatus tableStatus;

    public TableRestaurant(Builder builder) {
        this.id = builder.id;
        this.reservations = builder.reservations;
        this.seats = builder.seats;
        this.tableStatus = builder.tableStatus;
    }

    public static class Builder{
        private Integer id; //table number
        private Map<LocalDateTime, Reservation> reservations;
        private Integer seats;
        private TableStatus tableStatus;

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

        public Builder setTableStatus(TableStatus tableStatus){
            this.tableStatus = tableStatus;
            return this;
        }

        public TableRestaurant build(){
            return new TableRestaurant(this);
        }

    }

}
