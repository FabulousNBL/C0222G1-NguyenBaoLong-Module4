package blog.blog.repository;

import blog.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select * from category where status = 0",nativeQuery = true)
    List<Category> findAllCategory();

    @Modifying
    @Query(value = "insert into category (type) values (:type)", nativeQuery =true)
    void createCategory(@Param("type") String type);

    @Query(value = "select * from category where id = :id",nativeQuery = true)
    Category findById(@Param("id") int id);

    @Modifying
    @Query( value = "update category set type = :type where id = :id", nativeQuery = true)
    void update(@Param("type") String type,
                @Param("id") int id);

    @Modifying
    @Query(value = "update category set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

//    @Query(value = "select * from category where id = :id",nativeQuery = true)
//    Page<Category> search(Pageable pageable, @Param("type") String type);
}
