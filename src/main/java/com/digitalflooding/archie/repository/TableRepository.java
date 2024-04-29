package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.TableRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableRestaurant,Integer> {
}
