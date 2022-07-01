package com.example.blogajax.service.impl;

import com.example.blogajax.model.Category;
import com.example.blogajax.repository.ICategoryRepository;
import com.example.blogajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return iCategoryRepository.findAllCategory();
    }

    @Override
    public void createCategory(String type) {
        iCategoryRepository.createCategory(type);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void update(String type, int id) {
        iCategoryRepository.update(type, id);
    }

    @Override
    public void delete(int id) {
        iCategoryRepository.delete(id);
    }
}
