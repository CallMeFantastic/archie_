package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Orders;
import com.digitalflooding.archie.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    //CRUD OPERATIONS

    public Orders addOrder (Orders orders){
        return repository.save(orders);
    }

    public Orders updateOrder (Orders orders){
        return repository.save(orders);
    }

    public void deleteOrder(Long id){
        repository.deleteById(id);
    }

    public List<Orders> getOrders(){
        return repository.findAll();
    }
    
    public Optional<Orders> getOrder(Long id){
        return repository.findById(id);
    }
}
