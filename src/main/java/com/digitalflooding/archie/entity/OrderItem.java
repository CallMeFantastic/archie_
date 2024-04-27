package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Orders orders;

    private BigDecimal quantity;

    private BigDecimal totalPrice;
}
