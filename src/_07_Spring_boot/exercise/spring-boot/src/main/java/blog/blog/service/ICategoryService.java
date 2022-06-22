package blog.blog.service;

import blog.blog.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategory();

    void createCategory(String type);

    Category findById(int id);

    void update(String type , int id);

    void delete(int id);
}
