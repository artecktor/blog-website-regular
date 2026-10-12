package com.example.BlogWebsite.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Blog {
    private int id;
    private String title;
    private String author;
    private String content;
    private String description;
    private String imageAddress;
    private List<Comment> comments;
    private Category category;
    private Status status;
    private List<Tag> tags;
    private int viewCounter = 0;
    private String slug;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Blog(int id, String title, String author, String content, String description, String imageAddress, List<Comment> comments, Category category, Status status, List<Tag> tags, int viewCounter, String slug, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.description = description;
        this.imageAddress = imageAddress;
        this.comments = comments;
        this.category = category;
        this.status = status;
        this.tags = tags;
        this.viewCounter = viewCounter;
        this.slug = slug;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Blog() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(length = 10000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(length = 10000)
    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }


    @CreationTimestamp
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @UpdateTimestamp
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany
    @JoinTable(
            name = "blog_tags",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "blog")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getViewCounter() {
        return viewCounter;
    }

    public void setViewCounter(int viewCounter) {
        this.viewCounter = viewCounter;
    }

    @Column(unique = true, nullable = false)
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

