package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    public List<Blog> findByCategory(Category category);
    public List<Blog> findByTagsContaining(Tag tag);
    public List<Blog> findByStatus(Status status);
    public Blog findBySlug(String slug);
}
