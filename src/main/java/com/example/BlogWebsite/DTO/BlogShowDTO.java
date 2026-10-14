package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Model.Tag;

import java.time.LocalDateTime;
import java.util.List;

public class BlogShowDTO {
    private int id;
    private String title;
    private String author;
    private String content;
    private String description;
    private Category category;
    private Status status;
    private int viewCounter;
    private List<Tag> tags;
    private String slug;
    private String imageAddress;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private LocalDateTime publishedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getViewCounter() {
        return viewCounter;
    }

    public void setViewCounter(int viewCounter) {
        this.viewCounter = viewCounter;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public BlogShowDTO convertToDTO(Blog blog) {
        BlogShowDTO dto = new BlogShowDTO();

        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setAuthor(blog.getAuthor());
        dto.setContent(blog.getContent());
        dto.setDescription(blog.getDescription());
        dto.setImageAddress(blog.getImageAddress());
        dto.setCreationDate(blog.getCreationDate());
        dto.setUpdateDate(blog.getUpdateDate());
        dto.setCategory(blog.getCategory());
        dto.setTags(blog.getTags());
        dto.setViewCounter(blog.getViewCounter());
        dto.setStatus(blog.getStatus());
        dto.setSlug(blog.getSlug());
        dto.setPublishedDate(blog.getPublishedDate());
        return dto;
    }
}