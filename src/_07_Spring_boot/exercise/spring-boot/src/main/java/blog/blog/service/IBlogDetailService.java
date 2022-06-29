package blog.blog.service;

import blog.blog.model.BlogDetail;

import java.util.List;

public interface IBlogDetailService {
    List<BlogDetail> findAllBlogDetail();

    void create(String content);

   BlogDetail findBlogDetailById(int id);
}
