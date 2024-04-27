package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
