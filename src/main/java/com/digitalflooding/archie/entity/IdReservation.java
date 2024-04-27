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
    private LocalTime hour;


    private IdReservation(Builder builder) {
        this.idTable = builder.idTable;
        this.date = builder.date;
        this.hour = builder.hour;
    }

    public static class Builder {
        private Integer idTable;
        private LocalDate date;
        private LocalTime hour;

        public Builder setIdTable(Integer idTable) {
            this.idTable = idTable;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setHour(LocalTime hour){
            this.hour = hour;
            return this;
        }

        public IdReservation build() {
            return new IdReservation(this);
        }
    }
}
