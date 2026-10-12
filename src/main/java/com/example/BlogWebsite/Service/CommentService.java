package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    void update(Comment comment);
    void delete(Comment comment);
    void accept(int id);
    Comment findById(int id);
    List<Comment> findByUser(ApplicationUser user);
    List<Comment> findByBlog(Blog blog);
    List<Comment> findAll();
    List<Comment> findByBlogAndAcceptedTrueOrderByUpdatedAtDesc(Blog blog);
    List<Comment> findAllTrueOrderByUpdatedAtDesc();
}
