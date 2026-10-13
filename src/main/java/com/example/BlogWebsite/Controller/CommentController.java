package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.DTO.CommentSaveDTO;
import com.example.BlogWebsite.DTO.CommentShowDTO;
import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Comment;
import com.example.BlogWebsite.Service.ApplicationUserService;
import com.example.BlogWebsite.Service.BlogService;
import com.example.BlogWebsite.Service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    final CommentService commentService;
    final ApplicationUserService applicationUserService;
    final BlogService blogService;

    public CommentController(
            CommentService commentService,
            ApplicationUserService applicationUserService,
            BlogService blogService
    ) {
        this.commentService = commentService;
        this.applicationUserService = applicationUserService;
        this.blogService = blogService;
    }

    private Blog findBlogOr404(String slug) {
        Blog blog = blogService.findBySlug(slug);
        if (blog == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found: " + slug);
        }
        return blog;
    }

    @PostMapping
    public CommentShowDTO saveComment(@RequestBody CommentSaveDTO commentSaveDTO) {
        Comment comment = commentSaveDTO.convertToComment();

        comment.setBlog(blogService.findById(commentSaveDTO.getBlogId()));
        comment.setUser(applicationUserService.findByEmailAndPassword(
                commentSaveDTO.getEmail(),
                commentSaveDTO.getPassword()
        ));

        commentService.save(comment);

        return new CommentShowDTO().convertToDTO(comment);
    }

    @PostMapping("/update")
    public CommentShowDTO updateComment(CommentSaveDTO commentSaveDTO) {
        Comment comment = commentSaveDTO.convertToComment();

        comment.setBlog(blogService.findById(commentSaveDTO.getBlogId()));
        comment.setUser(applicationUserService.findByEmailAndPassword(
                commentSaveDTO.getEmail(),
                commentSaveDTO.getPassword()
        ));

        commentService.update(comment);

        return new CommentShowDTO().convertToDTO(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        Comment comment = commentService.findById(id);
        commentService.delete(comment);
    }

    @GetMapping("/{id}")
    public CommentShowDTO findById(@PathVariable int id) {
        Comment comment = commentService.findById(id);
        return new CommentShowDTO().convertToDTO(comment);
    }

    @GetMapping("/user/{id}")
    public List<CommentShowDTO> findByUserId(@PathVariable int id) {
        ApplicationUser user = applicationUserService.findById(id);

        return commentService.findByUser(user)
                .stream()
                .map(comment -> new CommentShowDTO().convertToDTO(comment))
                .toList();
    }

    @GetMapping("/blog/{slug}")
    public List<CommentShowDTO> findByBlogSlug(@PathVariable String slug) {
        return commentService.findByBlog(findBlogOr404(slug))
                .stream()
                .map(comment -> new CommentShowDTO().convertToDTO(comment))
                .toList();
    }

    @GetMapping("/blog/{slug}/sorted")
    public List<CommentShowDTO> findByBlogSlugSorted(@PathVariable String slug) {
        return commentService
                .findByBlogAndAcceptedTrueOrderByUpdatedAtDesc(findBlogOr404(slug))
                .stream()
                .map(comment -> new CommentShowDTO().convertToDTO(comment))
                .toList();
    }

    @GetMapping("/sorted")
    public List<CommentShowDTO> findAllSorted() {
        return commentService.findAllTrueOrderByUpdatedAtDesc()
                .stream()
                .map(comment -> new CommentShowDTO().convertToDTO(comment))
                .toList();
    }

    @GetMapping
    public List<CommentShowDTO> findAllComments() {
        return commentService.findAll()
                .stream()
                .map(comment -> new CommentShowDTO().convertToDTO(comment))
                .toList();
    }

    @GetMapping("/accept/{id}")
    public void accept(@PathVariable int id) {
        commentService.accept(id);
    }
}