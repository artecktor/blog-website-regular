package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.DTO.BlogShowDTO;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Service.BlogService;
import com.example.BlogWebsite.Service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;
    private final TagService tagService;

    public BlogController(BlogService blogService, TagService tagService) {
        this.blogService = blogService;
        this.tagService = tagService;
    }

    private Blog findBlog(String slug) {
        Blog blog = blogService.findBySlug(slug);
        return blog;
    }

    @PostMapping("/update")
    public void updateBlog(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBlog();
        blogService.update(blog);
    }

    @DeleteMapping("/{slug}")
    public void deleteBlog(@PathVariable String slug) {
        blogService.delete(findBlog(slug));
    }

    @GetMapping("/{slug}")
    public BlogShowDTO findBySlug(@PathVariable String slug) {
        return new BlogShowDTO().convertToDTO(findBlog(slug));
    }

    @GetMapping
    public List<BlogShowDTO> findAllBlogs() {
        return blogService.findAll()
                .stream()
                .map(blog -> new BlogShowDTO().convertToDTO(blog))
                .toList();
    }
    @GetMapping("/published")
    public List<BlogShowDTO> findAllBlogsPublished() {
        return blogService.findByStatus(Status.PUBLISHED)
                .stream()
                .map(blog -> new BlogShowDTO().convertToDTO(blog))
                .toList();
    }

    @GetMapping("/draft")
    public List<BlogShowDTO> findAllBlogsDraft() {
        return blogService.findByStatus(Status.DRAFT)
                .stream()
                .map(blog -> new BlogShowDTO().convertToDTO(blog))
                .toList();
    }
    @GetMapping("/tag/{tagId}")
    public List<BlogShowDTO> findByTag(@PathVariable int tagId) {
        return blogService.findByTagsContaining(tagService.findById(tagId))
                .stream()
                .map(blog -> new BlogShowDTO().convertToDTO(blog))
                .toList();
    }
}