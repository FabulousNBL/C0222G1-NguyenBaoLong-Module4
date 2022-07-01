package com.example.blogajax.service;
import com.example.blogajax.model.BlogDetail;

import java.util.List;

public interface IBlogDetailService {
    List<BlogDetail> findAllBlogDetail();

    void create(String content);

   BlogDetail findBlogDetailById(int id);
}
