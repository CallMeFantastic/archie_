package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
