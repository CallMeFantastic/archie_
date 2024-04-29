package com.digitalflooding.archie.dto;

import com.digitalflooding.archie.entity.Reservation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class CustomerDto {

    private Long id;
    private String customerSurname;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;
    private Boolean isPremium;
    private Map<LocalDateTime, Reservation> reservations;

    //@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    //private List<Order> orders;

    public CustomerDto(CustomerDto.Builder builder) {
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

        public CustomerDto.Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public CustomerDto.Builder setCustomerSurname(String customerSurname) {
            this.customerSurname = customerSurname;
            return this;
        }

        public CustomerDto.Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public CustomerDto.Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public CustomerDto.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerDto.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerDto.Builder setPremium(Boolean premium) {
            isPremium = premium;
            return this;
        }

        public CustomerDto.Builder setReservations(Map<LocalDateTime, Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public CustomerDto build(){
            return new CustomerDto(this);
        }

    }
}
