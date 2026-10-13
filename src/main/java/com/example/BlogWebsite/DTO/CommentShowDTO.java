package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.Comment;

import java.time.LocalDateTime;

public class CommentShowDTO {
    private int id;
    private String text;
    private int rating;
    private boolean accepted;
    private int blogId;
    private String blogSlug;
    private int userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogSlug() {
        return blogSlug;
    }

    public void setBlogSlug(String blogSlug) {
        this.blogSlug = blogSlug;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CommentShowDTO convertToDTO(Comment comment) {
        CommentShowDTO dto = new CommentShowDTO();

        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setRating(comment.getRating());
        dto.setAccepted(comment.isAccepted());
        dto.setBlogId(comment.getBlog().getId());
        dto.setBlogSlug(comment.getBlog().getSlug());
        dto.setUserId(comment.getUser().getId());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());

        return dto;
    }
}
