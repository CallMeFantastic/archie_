package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.TableRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableRestaurant,Integer> {

    @Query(value = "SELECT t.id, t.reservations, t.seats FROM reservation AS r " +
            "JOIN customer AS c ON r.id_customer = c.id " +
            "JOIN tablerestaurant AS t ON r.id_tavolo = t.id " +
            "WHERE r.date != ?1 AND r.time != ?2 AND t.seats = ?3 AND t.tableStatus = ACTIVE")
    List<TableRestaurant> findByData(LocalDate date, LocalTime time, Integer seats);
}
