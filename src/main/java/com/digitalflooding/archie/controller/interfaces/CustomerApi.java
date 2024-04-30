package com.digitalflooding.archie.controller.interfaces;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Reservation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
public interface CustomerApi {

    @GetMapping("/{customerId}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId); //permette di avere una risposta di tipo customer con la risposta contenente il codice http, es 200, 404, etc

    @GetMapping()
    ResponseEntity<List<Customer>> getAllCustomers();

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer);

    @DeleteMapping("/{customerId}")
    ResponseEntity<String> deleteCustomer(@PathVariable String customerId);
}
