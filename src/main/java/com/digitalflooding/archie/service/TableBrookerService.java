package com.digitalflooding.archie.service;

import com.digitalflooding.archie.dto.TableRestaurantDto;
import com.digitalflooding.archie.entity.TableRestaurant;
import com.digitalflooding.archie.repository.TableRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TableBrookerService { //table dispatcher

    private final TableRepository repository;
    private final ModelMapper modelMapper;

    private List<TableRestaurant> tablesList;

    @Autowired

    public TableBrookerService(TableRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        tablesList = new ArrayList<>();
    }

    //CRUD OPERATIONS

    public TableRestaurant addTable (TableRestaurantDto tableRestaurantDto){
        TableRestaurant tableRestaurant = modelMapper.map(tableRestaurantDto, TableRestaurant.class);
      if(repository.findById(tableRestaurantDto.getId()).isPresent()){
          log.info(String.format("Table id: %s already exist, updating...", tableRestaurantDto.getId()));
      }
        return repository.save(tableRestaurant);
    }

    public TableRestaurant updateTable (TableRestaurant tableRestaurant){
        return repository.save(tableRestaurant);
    }

    public void deleteTable(Long id){
        repository.deleteById(id);
    }

    public List<TableRestaurant> getTables(){
        return repository.findAll();
    }

    public Optional<TableRestaurant> getTable(Long id){
        return repository.findById(id);
    }
}
