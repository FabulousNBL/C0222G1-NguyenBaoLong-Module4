package com.example.blogajax.service;

import com.example.blogajax.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategory();

    void createCategory(String type);

    Category findById(int id);

    void update(String type , int id);

}
