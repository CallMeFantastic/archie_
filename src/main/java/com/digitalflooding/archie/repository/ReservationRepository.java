package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.IdReservation;
import com.digitalflooding.archie.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,IdReservation> {
    @Query(value = "SELECT idReservation FROM reservation AS r " +
            "JOIN customer AS c ON r.id_customer = c.id " +
            "JOIN tablerestaurant AS t ON r.id_tavolo = t.id " +
            "WHERE c.customerName = ?1 AND c.customerSurname = ?2 AND t.capacity = ?3")
    List<Reservation> findByCustomer(String name, String surname, Integer capacity);

    @Query(value = "SELECT * FROM reservation AS r " +
            "JOIN customer AS c ON r.id_customer = c.id " +
            "JOIN tablerestaurant AS t ON r.id_tavolo = t.id " +
            "WHERE r.date = ?1 AND r.time = ?2 AND c.customerSurname = ?3 AND t.seats = ?4")
    Reservation findByData(LocalDate date, LocalTime time, String surname, Integer seats);

}
