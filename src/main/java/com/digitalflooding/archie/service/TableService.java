package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.RestaurantTable;
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

    public RestaurantTable addTable (RestaurantTable restaurantTable){
        return repository.save(restaurantTable);
    }

    public RestaurantTable updateTable (RestaurantTable restaurantTable){
        return repository.save(restaurantTable);
    }

    public void deleteTable(Long id){
        repository.deleteById(id);
    }

    public List<RestaurantTable> getTables(){
        return repository.findAll();
    }

    public Optional<RestaurantTable> getTable(Long id){
        return repository.findById(id);
    }
}
