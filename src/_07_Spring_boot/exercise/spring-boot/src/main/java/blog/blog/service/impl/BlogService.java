package blog.blog.service.impl;


import blog.blog.model.Blog;
import blog.blog.model.BlogDetail;
import blog.blog.repository.IBlogDetailRepository;
import blog.blog.repository.IBlogRepository;
import blog.blog.service.IBlogService;
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
        blogRepository.create(title, createDay, content,category);
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
    public void update(String title,  String createDay,int category, int id) {
        blogRepository.update(title, createDay,category, id);
    }

    @Override
    public List<Blog> searchByTitle(String title) {
        return blogRepository.searchByTitle(title);
    }


}
