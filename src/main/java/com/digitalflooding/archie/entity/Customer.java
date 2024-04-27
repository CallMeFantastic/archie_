package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String businessName;

    private String customerNames;

    private String contactNumber;

    private String email;

    private String address;

    private Boolean isPremium;

    //@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    //private List<Order> orders;

    //@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    //private List<Reservation> reservations;

}
