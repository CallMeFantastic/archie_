package com.digitalflooding.archie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Embeddable
public class IdReservation {
    @Column(name="id_table", nullable=false)
    private Integer idTable;
    private LocalDate date;
    private LocalTime time;


    private IdReservation(Builder builder) {
        this.idTable = builder.idTable;
        this.date = builder.date;
        this.time = builder.time;
    }

    public static class Builder {
        private Integer idTable;
        private LocalDate date;
        private LocalTime time;

        public Builder setIdTable(Integer idTable) {
            this.idTable = idTable;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time){
            this.time = time;
            return this;
        }

        public IdReservation build() {
            return new IdReservation(this);
        }
    }
}
