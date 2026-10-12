package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void save(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Category category = categoryService.findById(id);
        categoryService.delete(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Category category) {
        category.setId(id);
        categoryService.save(category);
    }


    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
