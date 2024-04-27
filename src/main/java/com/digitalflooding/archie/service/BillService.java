package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Bill;
import com.digitalflooding.archie.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository repository;

    //CRUD OPERATIONS

    public Bill addBill (Bill bill){
        return repository.save(bill);
    }

    public Bill updateBill (Bill bill){
        return repository.save(bill);
    }

    public void deleteBill(Long id){
        repository.deleteById(id);
    }

    public List<Bill> getBills(){
        return repository.findAll();
    }

    public Optional<Bill> getBill(Long id){
        return repository.findById(id);
    }
}
