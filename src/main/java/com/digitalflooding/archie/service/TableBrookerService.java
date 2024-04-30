package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Reservation;
import com.digitalflooding.archie.entity.TableRestaurant;
import com.digitalflooding.archie.entity.TableStatus;
import com.digitalflooding.archie.repository.TableRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TableBrookerService { //table dispatcher

    private final TableRepository tableRepository;
    //private List<TableRestaurant> tablesList;

    @Autowired
    public TableBrookerService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
        //tablesList = tableRepository.findAll();
    }

    public TableRestaurant getFirstAvailablebyData(LocalDate date, LocalTime time, Integer seats){
        try {
            List<TableRestaurant> tableList = tableRepository.findByData(date, time, seats);
            return tableList.get(0);
        }   catch(Exception e){
            log.error("No available tables found");
            return null;
        }
    }

    //CRUD OPERATIONS

    //aggiunta prenotazione, bisogna agganciare la prenotazione all'oggetto tavolo e cliente
    public TableRestaurant addTable (TableRestaurant tableRestaurant){
        if(tableRepository.findById(tableRestaurant.getId()).isPresent()){
            log.info(String.format("Table id: %s already exist", tableRestaurant.getId()));
            return null;
        }
        return tableRepository.save(tableRestaurant);
    }

    public TableRestaurant updateTable(TableRestaurant tableInput, Reservation reservation){
        Optional<TableRestaurant> tableOptional =  tableRepository.findById(tableInput.getId());
        if(tableOptional.isPresent()){
            TableRestaurant table = tableOptional.get();
            if(reservation!=null){
                LocalDateTime key = LocalDateTime.of(reservation.getIdReservation().getDate(), reservation.getIdReservation().getTime());
                table.getReservations().put(key, reservation);
            }
            if(tableInput.getSeats()!=null){
                table.setSeats(tableInput.getSeats());
            }
            tableRepository.save(table);
            return table;
        }   else{
                log.error("Table do not exist");
                return null;
            }
    }

    public void deleteTable(Integer id){
        tableRepository.deleteById(id);
    }

    public List<TableRestaurant> getTables(){
        return tableRepository.findAll();
    }

    public Optional<TableRestaurant> getTable(Integer id){
        return tableRepository.findById(id);
    }
}
