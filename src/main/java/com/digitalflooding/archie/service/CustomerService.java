package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Reservation;
import com.digitalflooding.archie.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //controlla se il customer inserito esiste
    public Customer doesCustomerExist(String name, String surname, String contactNumber){
      return customerRepository.findCustomerByData(name, surname, contactNumber);
      }

    //CRUD OPERATIONS

    //le entità indipendenti le costruisco fuori dai metodi crud e gliele passo come dipendenze, così non rinuncio alla flessibilità data dal pattern builder
    //l'entità dipendente Reservation invece per semplicità la assemblo dentro il service
    public Customer addCustomer (Customer customer){
        if(customerRepository.findByContactNumber(customer.getContactNumber())==null){
            log.info(String.format("Customer %s %s already exist", customer.getCustomerName(), customer.getCustomerSurname()));
            return null;
        }
        return customerRepository.save(customer);
    }

    public Customer updateCustomer (Customer customerInput, Reservation reservation){
       // public Customer updateCustomer (Long id, String customerSurname, String customerName, String contactNumber, String email, String address, Boolean isPremium, Reservation reservation){
        Optional<Customer> customerOptional =  customerRepository.findById(customerInput.getId());
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            if(reservation!=null){
                LocalDateTime key = LocalDateTime.of(reservation.getIdReservation().getDate(), reservation.getIdReservation().getTime());
                customer.getReservations().put(key, reservation);
            }
            if(!Objects.equals(customer.getCustomerName(), customerInput.getCustomerName())){
                customer.setCustomerName(customerInput.getCustomerName());
            }
            if(!Objects.equals(customer.getCustomerSurname(), customerInput.getCustomerSurname())){
                customer.setCustomerSurname(customer.getCustomerSurname());
            }
            if(!Objects.equals(customer.getContactNumber(), customerInput.getContactNumber())){
                customer.setContactNumber(customerInput.getContactNumber());
            }
            if(!Objects.equals(customer.getEmail(), customerInput.getEmail())){
                customer.setEmail(customerInput.getEmail());
            }
            if(!Objects.equals(customer.getAddress(), customerInput.getAddress())){
                customer.setAddress(customerInput.getAddress());
            }
            if(customer.getIsPremium()!=customerInput.getIsPremium()){
                customer.setIsPremium(customerInput.getIsPremium());
            }
          return customerRepository.save(customer);
        }   else{
                log.error("Table do not exist");
                return null;
            }
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long id){
        return customerRepository.findById(id);
    }
}
