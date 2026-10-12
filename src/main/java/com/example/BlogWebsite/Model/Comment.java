package com.example.BlogWebsite.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Comment {
    private int id;
    private String text;
    private Blog blog;
    private ApplicationUser user;
    private int rating;
    private boolean accepted = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Comment(int id, String text, Blog blog, ApplicationUser user, int rating, boolean accepted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.text = text;
        this.blog = blog;
        this.user = user;
        this.rating = rating;
        this.accepted = accepted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Comment() {

    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    @JoinColumn(name = "blog_id")
    @ManyToOne
    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 10000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @CreationTimestamp
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @UpdateTimestamp
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
