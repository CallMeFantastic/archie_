package com.digitalflooding.archie.repository;

import com.digitalflooding.archie.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT * FROM customer AS c WHERE c.customerName = ?1 AND c.customerSurname = ?2 AND c.contactNumber = ?3")
    Customer findCustomerByData(String name, String surname, String contactNumber);
}
