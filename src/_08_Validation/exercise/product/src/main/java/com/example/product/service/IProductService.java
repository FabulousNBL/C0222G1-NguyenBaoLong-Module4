package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService {

    Page<Product> findAllProduct(Pageable pageable);

    void create( String name,
                Double price,
                String description,
                String producer);

    Product findById(int id);

    void update (String name,
                 Double price,
                 String description,
                 String producer,
                 int id);

    void delete( int id);

    Page<Product> searchByName(String name, Pageable pageable);
}
