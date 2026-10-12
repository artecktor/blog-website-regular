package com.example.BlogWebsite.Service;


import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);

    void update(Category category);

    void delete(Category category);

    Category findById(int id);

    List<Category> findAll();

}
