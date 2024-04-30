package com.digitalflooding.archie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String customerSurname;

    @NotNull
    private String customerName;

    @NotNull
    @Column(unique=true)
    private String contactNumber;

    private String email;

    private String address;

    @NotNull
    private Boolean isPremium;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST) //da rivedere il cascade
    private Map<LocalDateTime, Reservation> reservations;

    //@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    //private List<Order> orders;


    public Customer(Builder builder) {
        this.id = builder.id;
        this.customerSurname = builder.customerSurname;
        this.customerName = builder.customerName;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.address = builder.address;
        this.isPremium = builder.isPremium;
        this.reservations = builder.reservations;
    }

    public static class Builder{
        private Long id;
        private String customerSurname;
        private String customerName;
        private String contactNumber;
        private String email;
        private String address;
        private Boolean isPremium;
        private Map<LocalDateTime, Reservation> reservations;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerSurname(String customerSurname) {
            this.customerSurname = customerSurname;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPremium(Boolean premium) {
            isPremium = premium;
            return this;
        }

        public Builder setReservations(Map<LocalDateTime, Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }

    }
}
