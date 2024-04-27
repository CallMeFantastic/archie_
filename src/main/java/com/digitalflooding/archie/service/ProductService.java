package com.digitalflooding.archie.service;

import com.digitalflooding.archie.entity.Customer;
import com.digitalflooding.archie.entity.Product;
import com.digitalflooding.archie.repository.CustomerRepository;
import com.digitalflooding.archie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //CRUD OPERATIONS

    public Product addProduct (Product product){
        return repository.save(product);
    }

    public Product updateProduct (Product product){
        return repository.save(product);
    }

    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Optional<Product> getProduct(Long id){
        return repository.findById(id);
    }
}
