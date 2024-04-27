package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String tableNumber;

    private BigDecimal capacity;

    private TableStatus status;

}
