package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    //CRUD OPERATIONS

    public Customer addCustomer (Customer customer){
        return repository.save(customer);
    }

    public Customer updateCustomer (Customer customer){
        return repository.save(customer);
    }

    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    public Optional<Customer> getCustomer(Long id){
        return repository.findById(id);
    }
}
