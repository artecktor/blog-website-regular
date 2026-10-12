package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findByBlog(Blog blog);
    public List<Comment> findByUser(ApplicationUser user);
    public List<Comment> findByBlogAndAcceptedTrueOrderByUpdatedAtDesc(Blog blog);
    public List<Comment> findAllByOrderByUpdatedAtDesc();
}
