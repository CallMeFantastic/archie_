package com.digitalflooding.archie.service;

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
    private final CustomerService customerService;
    private final TableBrookerService tableBrooker;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, TableRepository tableRepository, CustomerService customerService, ModelMapper modelMapper, TableBrookerService tableBrooker) {
        this.reservationRepository = reservationRepository;
        this.customerService = customerService;
        this.tableBrooker = tableBrooker;
    }

    public TimeSlot slotAllocation(LocalTime time){
        if(time.isAfter(LocalTime.parse("12:00")) && time.isBefore(LocalTime.parse("13:00"))){
            return TimeSlot.SLOT1L;
        }
        if(time.isAfter(LocalTime.parse("13:00")) && time.isBefore(LocalTime.parse("14:00"))){
            return TimeSlot.SLOT2L;
        }
        if(time.isAfter(LocalTime.parse("14:00")) && time.isBefore(LocalTime.parse("15:00"))){
            return TimeSlot.SLOT3L;
        }
        if(time.isAfter(LocalTime.parse("20:00")) && time.isBefore(LocalTime.parse("21:00"))){
            return TimeSlot.SLOT1D;
        }
        if(time.isAfter(LocalTime.parse("21:00")) && time.isBefore(LocalTime.parse("22:00"))){
            return TimeSlot.SLOT2D;
        }
        if(time.isAfter(LocalTime.parse("22:00")) && time.isBefore(LocalTime.parse("23:00"))){
            return TimeSlot.SLOT3D;
        }
        return null;
    }

    //CRUD OPERATIONS

    public Reservation addReservation(LocalDate reservationDate, LocalTime reservationTime, Integer seats, String name, String surname, String contactNumber){
        try{
            TableRestaurant tableAvailable = tableBrooker.getFirstAvailablebyData(reservationDate, reservationTime, seats);
            if (tableAvailable!=null) {
                IdReservation idReservation =  new IdReservation.Builder()
                    .setIdTable(tableAvailable.getId())
                    .setDate(reservationDate)
                    .setTime(reservationTime)
                    .build();
                Customer customer = customerService.doesCustomerExist(name, surname, contactNumber);
                if(customer==null) {
                    customer = new Customer.Builder().setCustomerName(name).setCustomerSurname(surname).setContactNumber(contactNumber).setPremium(false).build();
                    customerService.addCustomer(customer);
                }
                TimeSlot slot = slotAllocation(reservationTime);
                Reservation reservation = new Reservation.Builder()
                        .setIdReservation(idReservation)
                        .setTableRestaurant(tableAvailable)
                        .setCustomer(customer)
                        .setTimestamp(LocalDateTime.now())
                        .setTimeSlot(slot)
                        .build();
                tableBrooker.updateTable(tableAvailable, reservation);
                reservationRepository.save(reservation);
                return reservation;
            }   else{
                    log.error("Table already booked for this reservationTime slot");
                    return null;
                }
        }   catch (Exception e){
                log.error("Error during table booking occured.");
                return null;
            }
    }

    public Reservation updateReservation (LocalDate newReservationDate, LocalTime newReservationTime, Integer newSeats, LocalDate oldReservationDate, LocalTime oldReservationTime, Integer oldSeats, String surname){
        Reservation reservation = getReservationByData(surname, oldReservationDate, oldReservationTime, oldSeats);
        if (oldReservationDate!=newReservationDate || oldReservationTime!=newReservationTime && oldSeats.intValue()==newSeats.intValue()){
            IdReservation idReservation =  new IdReservation.Builder()
                                                            .setIdTable(reservation.getTableRestaurant().getId())
                                                            .setDate(newReservationDate)
                                                            .setTime(newReservationTime)
                                                            .build();
            reservation.setIdReservation(idReservation);
        }
        if (oldSeats.intValue()!=newSeats.intValue()){
            TableRestaurant tableAvailable = tableBrooker.getFirstAvailablebyData(newReservationDate, newReservationTime, newSeats);
            IdReservation idReservation =  new IdReservation.Builder()
                                                            .setIdTable(tableAvailable.getId())
                                                            .setDate(newReservationDate)
                                                            .setTime(newReservationTime)
                                                            .build();
            reservation.setIdReservation(idReservation);
            reservation.setTableRestaurant(tableAvailable);
        }
        return reservationRepository.save(reservation);
    }

    public Boolean deleteReservation(LocalDate reservationDate, LocalTime reservationTime, String surname, Integer seats){
        Reservation reservation = getReservationByData(surname, reservationDate, reservationTime, seats);
        try{
            reservationRepository.deleteById(reservation.getIdReservation());
        } catch(Exception e){
            log.error("Reservation not found");
            return false;
        }
        return true;
    }

    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(IdReservation isReservation){
        return reservationRepository.findById(isReservation);
    }

    public Reservation getReservationByData(String surname, LocalDate date, LocalTime time, Integer seats){
        return reservationRepository.findByData(date, time, surname, seats);
    }

    public List<Reservation> getReservationsByCustomer(String nome, String cognome, Integer nPosti){
        List<Reservation> listaPrenotazioni;
        try{
            listaPrenotazioni = reservationRepository.findByCustomer(nome, cognome, nPosti);
        } catch(Exception e){
            log.error("Prenotazioni non trovate.");
            return null;
        }
        return listaPrenotazioni;
    }
}
