package blog.blog.service.impl;

import blog.blog.model.BlogDetail;
import blog.blog.repository.IBlogDetailRepository;
import blog.blog.service.IBlogDetailService;
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
}
