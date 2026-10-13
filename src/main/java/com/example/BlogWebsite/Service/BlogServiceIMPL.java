package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Repository.BlogRepository;
import com.example.BlogWebsite.Repository.CommentRepository;
import com.example.BlogWebsite.Model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceIMPL implements BlogService {
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    public BlogServiceIMPL(BlogRepository blogRepository, CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Blog blog) {
        if (blog.getStatus() == Status.PUBLISHED) {
            blog.setPublishedDate(java.time.LocalDateTime.now());
        } else {
            blog.setPublishedDate(null);
        }

        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        commentRepository.deleteAll(commentRepository.findByBlog(blog));
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategory(Category category) {
        return blogRepository.findByCategory(category);
    }

    @Override
    public List<Blog> findByTagsContaining(Tag tag) {
        return blogRepository.findByTagsContaining(tag);
    }

    @Override
    public List<Blog> findByStatus(Status status) {
        return blogRepository.findByStatus(status);
    }

    @Override
    public void incrementViewCounter(int blogId) {
        Blog blog = findById(blogId);
        blog.setViewCounter(blog.getViewCounter() + 1);
        blogRepository.save(blog);
    }

    @Override
    public Blog findBySlug(String slug) {
        return blogRepository.findBySlug(slug);
    }
}
