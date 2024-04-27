package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Calendar orderDate;

    private OrderStatus status;

    private OrderStatus completedStatus = OrderStatus.CREATED;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<OrderItem> positions;

    @OneToOne
    private Bill bill;

}
