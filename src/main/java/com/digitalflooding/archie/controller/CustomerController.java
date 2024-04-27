package com.digitalflooding.archie.controller;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/Customer/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        try{

            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
