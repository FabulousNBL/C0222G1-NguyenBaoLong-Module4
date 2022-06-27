package com.example.book.service.book;

import com.example.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Book findById(int id);
}
