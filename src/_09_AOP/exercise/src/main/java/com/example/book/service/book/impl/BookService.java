package com.example.book.service.book.impl;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }
}
