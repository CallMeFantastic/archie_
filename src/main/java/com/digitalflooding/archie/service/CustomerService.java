package com.digitalflooding.archie.service;

import com.digitalflooding.archie.dto.CustomerDto;
import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository ;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    //controlla se il customer inserito esiste
    public Customer doesCustomerExist(CustomerDto customerDto){
      return repository.findCustomerByData(customerDto.getCustomerName(), customerDto.getCustomerSurname(), customerDto.getContactNumber());
      }

    //CRUD OPERATIONS

    public Customer addCustomer (Customer customerDto){
        Customer customer = new Customer.Builder().setCustomerName(customerDto.getCustomerName()).setCustomerSurname(customerDto.getCustomerSurname()).setAddress()
        return repository.save(customerDto);
    }

    public Customer updateCustomer (Customer customerDto){
        return repository.save(customerDto);
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
