package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.Comment;

public class CommentSaveDTO {
    private Integer id;
    private String text;
    private int rating;
    private int blogId;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CommentSaveDTO(Integer id, String text, int rating, int blogId, String email, String password) {
        this.id = id;
        this.text = text;
        this.rating = rating;
        this.blogId = blogId;
        this.email = email;
        this.password = password;
    }

    public Comment convertToComment() {
        Comment comment = new Comment();
        comment.setText(text);
        comment.setRating(rating);
        return comment;
    }
}
