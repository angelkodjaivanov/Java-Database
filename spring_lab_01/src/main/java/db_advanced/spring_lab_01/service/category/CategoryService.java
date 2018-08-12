package db_advanced.spring_lab_01.service.category;

import db_advanced.spring_lab_01.model.Category;

import java.util.List;


public interface CategoryService {
    void save(Category category);

    List<Category> getAllCategories();
}
