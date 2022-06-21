package blog.service.impl;

import blog.model.Blog;
import blog.model.BlogDetail;
import blog.repository.IBlogDetailRepository;
import blog.repository.IBlogRepository;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private IBlogDetailRepository blogDetailRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlog();
    }


    @Override
    public void create(String content) {
        blogDetailRepository.create(content);
    }

    @Override
    public void create(String title, String createDay) {
        blogRepository.create(title, createDay);
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
    public void update(String title, String content, String createDay, int id) {
        blogRepository.update(title, content, createDay, id);
    }

    @Override
    public List<BlogDetail> findAllBlogDetail() {
        return blogDetailRepository.findAllBlogDetail();
    }
}
