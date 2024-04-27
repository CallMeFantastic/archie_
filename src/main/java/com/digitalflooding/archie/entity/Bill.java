package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal totalAmount;

    @OneToOne
    private Order order;

    private PaymentStatus paymentStatus;

}
