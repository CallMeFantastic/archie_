package com.digitalflooding.archie.service;

import com.digitalflooding.archie.dto.CustomerDto;
import com.digitalflooding.archie.dto.ReservationDto;
import com.digitalflooding.archie.dto.TableRestaurantDto;
import com.digitalflooding.archie.entity.*;
import com.digitalflooding.archie.repository.ReservationRepository;
import com.digitalflooding.archie.repository.TableRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TableRepository tableRepository;
    private final CustomerService customerService;
    private final ModelMapper modelMapper;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository, TableRepository tableRepository, CustomerService customerService, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.tableRepository = tableRepository;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    public ReservationDto addReservation(LocalDate reservationDate, LocalTime reservationTime, TableRestaurantDto tableDto, CustomerDto customerDto){

        IdReservation idReservation =  new IdReservation.Builder()
                .setIdTable(tableDto.getId())
                .setDate(reservationDate)
                .setTime(reservationTime)
                .build();
        Customer customer = customerService.doesCustomerExist(customerDto);

        if(customer==null) {
            //creazione anagrafica se non esiste (interrogare l'apposita api sul controller?)
        }
        try{
            Optional<TableRestaurant> table = tableRepository.findById(tableDto.getId());
            if(checkTableAlreadyAssigned(idReservation) && table.isPresent()) {
                TimeSlot slot = slotAllocation(reservationTime);
                Reservation reservation = new Reservation.Builder()
                        .setIdReservation(idReservation)
                        .setTableRestaurant(table.get())
                        .setCustomer(customer)
                        .setTimestamp(LocalDateTime.now())
                        .setTimeSlot(slot)
                        .build();
                reservationRepository.save(reservation);
                return modelMapper.map(reservation, ReservationDto.class);
            }
            else{
                log.error("Table already booked for this reservationTime slot");
                return null;
            }
        }   catch (Exception e){
                log.error("Error during table booking occured.");
                return null;
            }
    }

    public Boolean deleteReservation(LocalDate reservationDate, LocalTime reservationTime, TableRestaurantDto table){
        IdReservation idReservation =  new IdReservation.Builder()
                .setIdTable(table.getId())
                .setDate(reservationDate)
                .setTime(reservationTime)
                .build();
        try{
            reservationRepository.deleteById(idReservation);
        } catch(Exception e){
            log.error("Reservation not found");
            return false;
        }
        return true;
    }

    public List<Reservation> ricercaPrenotazioniPerCliente(String nome, String cognome, Integer nPosti){
        List<Reservation> listaPrenotazioni;
        try{
            listaPrenotazioni = reservationRepository.findByCustomer(nome, cognome, nPosti);
        } catch(Exception e){
            log.error("Prenotazioni non trovate.");
            return null;
        }
        return listaPrenotazioni;
    }

    public Boolean checkTableAlreadyAssigned(IdReservation idReservation){
        Optional<Reservation> risultatoRicerca = reservationRepository.findById(idReservation);
        return risultatoRicerca.isPresent();
    }


    public TimeSlot slotAllocation(LocalTime orario){
        if(orario.isAfter(LocalTime.parse("12:00")) && orario.isBefore(LocalTime.parse("13:00"))){
            return TimeSlot.FASCIA1P;
        }
        if(orario.isAfter(LocalTime.parse("13:00")) && orario.isBefore(LocalTime.parse("14:00"))){
            return TimeSlot.FASCIA2P;
        }
        if(orario.isAfter(LocalTime.parse("14:00")) && orario.isBefore(LocalTime.parse("15:00"))){
            return TimeSlot.FASCIA3P;
        }
        if(orario.isAfter(LocalTime.parse("20:00")) && orario.isBefore(LocalTime.parse("21:00"))){
            return TimeSlot.FASCIA1C;
        }
        if(orario.isAfter(LocalTime.parse("21:00")) && orario.isBefore(LocalTime.parse("22:00"))){
            return TimeSlot.FASCIA2C;
        }
        if(orario.isAfter(LocalTime.parse("22:00")) && orario.isBefore(LocalTime.parse("23:00"))){
            return TimeSlot.FASCIA3C;
        }
        return null;
    }








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
