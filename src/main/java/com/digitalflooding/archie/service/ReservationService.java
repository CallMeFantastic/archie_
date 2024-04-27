package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Reservation;
import com.digitalflooding.archie.repository.CustomerRepository;
import com.digitalflooding.archie.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    //CRUD OPERATIONS

    public Reservation addReservation (Reservation reservation){
        return repository.save(reservation);
    }

    public Reservation updateReservation (Reservation reservation){
        return repository.save(reservation);
    }

    public void deleteReservation(Long id){
        repository.deleteById(id);
    }

    public List<Reservation> getReservations(){
        return repository.findAll();
    }

    public Optional<Reservation> getReservation(Long id){
        return repository.findById(id);
    }
}
