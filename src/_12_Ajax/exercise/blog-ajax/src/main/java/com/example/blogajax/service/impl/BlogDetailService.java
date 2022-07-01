package com.example.blogajax.service.impl;

import com.example.blogajax.model.BlogDetail;
import com.example.blogajax.repository.IBlogDetailRepository;
import com.example.blogajax.service.IBlogDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogDetailService implements IBlogDetailService {
    @Autowired
    private IBlogDetailRepository blogDetailRepository;

    @Override
    public List<BlogDetail> findAllBlogDetail() {
        return blogDetailRepository.findAllBlogDetail();
    }

    @Override
    public void create(String content) {
        blogDetailRepository.create(content);
    }

    @Override
    public BlogDetail findBlogDetailById(int id) {
        return blogDetailRepository.findById(id).orElse(null);
    }
}
