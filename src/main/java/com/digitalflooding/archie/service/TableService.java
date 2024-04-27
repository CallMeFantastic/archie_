package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Table;
import com.digitalflooding.archie.repository.CustomerRepository;
import com.digitalflooding.archie.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository repository;

    //CRUD OPERATIONS

    public Table addTable (Table table){
        return repository.save(table);
    }

    public Table updateTable (Table table){
        return repository.save(table);
    }

    public void deleteTable(Long id){
        repository.deleteById(id);
    }

    public List<Table> getTables(){
        return repository.findAll();
    }

    public Optional<Table> getTable(Long id){
        return repository.findById(id);
    }
}
