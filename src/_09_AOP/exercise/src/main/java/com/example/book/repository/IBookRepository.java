package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where status = 0", nativeQuery = true)
    Page<Book> findAll(Pageable pageable);

    @Query(value = "select * from book where id = :id", nativeQuery = true)
    Book findById(@Param("id") int id);
}
