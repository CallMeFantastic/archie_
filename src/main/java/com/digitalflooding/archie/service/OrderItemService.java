package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.OrderItem;
import com.digitalflooding.archie.repository.CustomerRepository;
import com.digitalflooding.archie.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    //CRUD OPERATIONS

    public OrderItem addOrderItem (OrderItem orderItem){
        return repository.save(orderItem);
    }

    public OrderItem updateOrderItem (OrderItem orderItem){
        return repository.save(orderItem);
    }

    public void deleteOrderItem(Long id){
        repository.deleteById(id);
    }

    public List<OrderItem> getOrderItems(){
        return repository.findAll();
    }

    public Optional<OrderItem> getOrderItem(Long id){
        return repository.findById(id);
    }
}
