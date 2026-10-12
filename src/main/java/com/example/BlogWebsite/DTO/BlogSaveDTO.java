package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Model.Tag;

import java.util.List;

public class BlogSaveDTO {
    private Integer id;
    private String title;
    private String author;
    private String content;
    private String slug;
    private Category category;
    private Status status;
    private List<Tag> tags;
    private String description;
    private String imageAddress;

    public BlogSaveDTO(Integer id, String title, String author, String content, String slug, Category category, Status status, List<Tag> tags, String description, String imageAddress) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.slug = slug;
        this.category = category;
        this.status = status;
        this.tags = tags;
        this.description = description;
        this.imageAddress = imageAddress;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {this.author = author;}

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Blog convertToBlog() {
        Blog blog = new Blog();
        if (id != null) {
            blog.setId(id);
        }
        blog.setTitle(this.title);
        blog.setAuthor(this.author);
        blog.setDescription(this.description);
        blog.setImageAddress(this.imageAddress);
        blog.setContent(this.content);
        blog.setCategory(this.category);
        blog.setStatus(this.status);
        blog.setTags(this.tags);
        blog.setSlug(this.slug);
        return blog;
    }
}
