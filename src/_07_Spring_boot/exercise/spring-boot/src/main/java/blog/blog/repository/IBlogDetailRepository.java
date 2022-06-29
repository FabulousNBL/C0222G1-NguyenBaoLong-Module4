package blog.blog.repository;


import blog.blog.model.BlogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBlogDetailRepository extends JpaRepository<BlogDetail,Integer> {


    @Query(value = "select * from blog_detail", nativeQuery = true)
    List<BlogDetail> findAllBlogDetail();

    @Modifying
    @Query(value = "insert into blog_detail (content) values (:content) ", nativeQuery = true)
    void create(@Param("content") String content);


}
