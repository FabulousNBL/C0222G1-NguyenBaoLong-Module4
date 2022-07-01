package com.example.blogajax.service;

import com.example.blogajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void create(String title, String createDay, int contentId, int category);

    void delete(int id);

    Blog findById(int id);

    void update(String title, String createDay, int category, int id);

    List<Blog> searchByTitle(String title, Pageable pageable);

    Page<Blog> list(int category, Pageable pageable);

    void update(Blog blog);
}
