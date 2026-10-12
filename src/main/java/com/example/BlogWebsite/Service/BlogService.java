package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Model.Tag;

import java.util.List;

public interface BlogService {
    void save(Blog blog);
    void update(Blog blog);
    void delete(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    List<Blog> findByCategory(Category category);
    List<Blog> findByTagsContaining(Tag tag);
    List<Blog> findByStatus(Status status);
    void incrementViewCounter(int blogId);
    Blog findBySlug(String slug);
}
