package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.DTO.BlogShowDTO;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Status;
import com.example.BlogWebsite.Service.BlogService;
import com.example.BlogWebsite.Service.TagService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")
    public void updateBlog(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBlog();
        blogService.update(blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
    }

    @GetMapping("/{id}")
    public BlogShowDTO findById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new BlogShowDTO().convertToDTO(blog);
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