package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.Model.Category;
import com.example.BlogWebsite.Service.TagService;
import com.example.BlogWebsite.Model.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Tag tag = tagService.findById(id);
        tagService.delete(tag);
    }

    @PostMapping
    public void save(@RequestBody Tag tag) {
        tagService.save(tag);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Tag tag) {
        tag.setId(id);
        tagService.save(tag);
    }

    @GetMapping("/{id}")
    public Tag findById(@PathVariable int id) {
        return tagService.findById(id);
    }

    @GetMapping
    public List<Tag> findAll() {
        return tagService.findAll();
    }
}
