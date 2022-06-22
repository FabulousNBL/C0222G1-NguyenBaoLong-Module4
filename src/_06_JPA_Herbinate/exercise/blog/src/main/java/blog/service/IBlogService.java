package blog.service;

import blog.model.Blog;
import blog.model.BlogDetail;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(String title, String createDay, int contentId);

    void delete(int id);

    Blog findById(int id);

    void update(String title, String content, String createDay, int id);

    List<BlogDetail> findAllBlogDetail();

    void create(String content);
}
