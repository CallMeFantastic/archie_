package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
