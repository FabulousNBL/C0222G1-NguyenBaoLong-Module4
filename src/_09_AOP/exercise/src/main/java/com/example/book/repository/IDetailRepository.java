package com.example.book.repository;

import com.example.book.model.Detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IDetailRepository extends JpaRepository<Detail, Integer> {
    @Query(value = "select * from detail", nativeQuery = true)
    Page<Detail> findAll(Pageable pageable);

    @Query(value = "select * from detail where borrow_code = :id", nativeQuery = true)
    Detail findById(@Param("id") String id);
}
