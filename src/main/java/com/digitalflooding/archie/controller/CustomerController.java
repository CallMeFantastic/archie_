package com.digitalflooding.archie.controller;

import com.digitalflooding.archie.controller.interfaces.CustomerApi;
import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Reservation;
import com.digitalflooding.archie.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Long customerId) {
        try {
            Optional<Customer> customerOptional = customerService.getCustomer(customerId);
            return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
        }   catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customerList = customerService.getCustomers();
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }   catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @Override
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer outCustomer = customerService.addCustomer(customer);
            return new ResponseEntity<>(outCustomer, HttpStatus.OK);
        }   catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        try {
            Customer outCustomer = customerService.updateCustomer(customer);
            return new ResponseEntity<>(outCustomer, HttpStatus.OK);
        }   catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @Override
    public ResponseEntity<String> deleteCustomer(String customerId) {
        try {
            customerService.deleteCustomer(Long.getLong(customerId));
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }   catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

}
