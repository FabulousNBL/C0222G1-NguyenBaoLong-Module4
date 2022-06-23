package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where status = 0", nativeQuery = true)
    Page<Product> findAllProduct(Pageable pageable);

    @Modifying
    @Query(value = "insert into product (name, price, description, producer) values (:name, :price, :description, :producer)", nativeQuery = true)
    void create(@Param("name") String name,
                @Param("price") Double price,
                @Param("description") String description,
                @Param("producer") String producer);

    @Query(value = "select * from product where id = :id",nativeQuery = true)
    Product findById(@Param("id") int id);

    @Modifying
    @Query(value = "update product set name = :name, price = :price , description = :description, producer = :producer where id = :id", nativeQuery= true)
    void update (@Param("name") String name,
                 @Param("price") Double price,
                 @Param("description") String description,
                 @Param("producer") String producer,
                 @Param("id") int id);

    @Modifying
    @Query(value = "update product set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from product where name like %:name%", nativeQuery = true)
    Page<Product> searchByName(@Param("name") String name, Pageable pageable);
}
