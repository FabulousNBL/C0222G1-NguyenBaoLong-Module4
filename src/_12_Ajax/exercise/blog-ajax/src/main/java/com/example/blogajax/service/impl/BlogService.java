package com.example.blogajax.service.impl;

import com.example.blogajax.model.Blog;
import com.example.blogajax.repository.IBlogDetailRepository;
import com.example.blogajax.repository.IBlogRepository;
import com.example.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private IBlogDetailRepository blogDetailRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAllBlog(pageable);
    }


    @Override
    public void create(String title, String createDay, int content, int category) {
        blogRepository.create(title, createDay, content, category);
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(String title, String createDay, int category, int id) {
        blogRepository.update(title, createDay, category, id);
    }

    @Override
    public List<Blog> searchByTitle(String title, Pageable pageable) {
        return blogRepository.searchByTitle(title, pageable);
    }

    @Override
    public Page<Blog> list(int category, Pageable pageable) {
        return blogRepository.list(category, pageable);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }


}
