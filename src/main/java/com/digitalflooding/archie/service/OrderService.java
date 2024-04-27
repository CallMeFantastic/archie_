package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Order;
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

    public Order addOrder (Order order){
        return repository.save(order);
    }

    public Order updateOrder (Order order){
        return repository.save(order);
    }

    public void deleteOrder(Long id){
        repository.deleteById(id);
    }

    public List<Order> getOrders(){
        return repository.findAll();
    }
    
    public Optional<Order> getOrder(Long id){
        return repository.findById(id);
    }
}
