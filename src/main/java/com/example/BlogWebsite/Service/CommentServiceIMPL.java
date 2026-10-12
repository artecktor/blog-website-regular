package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Comment;
import com.example.BlogWebsite.Repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceIMPL implements CommentService {
    final CommentRepository commentRepository;

    public CommentServiceIMPL(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Transactional
    @Override
    public void accept(int id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setAccepted(true);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByUser(ApplicationUser user) {
        return commentRepository.findByUser(user);
    }

    @Override
    public List<Comment> findByBlog(Blog blog) {
        return commentRepository.findByBlog(blog);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByBlogAndAcceptedTrueOrderByUpdatedAtDesc(Blog blog) {
        return commentRepository.findByBlogAndAcceptedTrueOrderByUpdatedAtDesc(blog);
    }

    @Override
    public List<Comment> findAllTrueOrderByUpdatedAtDesc() {
        return commentRepository.findAllByOrderByUpdatedAtDesc();
    }


}
