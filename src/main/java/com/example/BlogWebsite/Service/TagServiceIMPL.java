package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Repository.TagRepository;
import com.example.BlogWebsite.Model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceIMPL implements TagService {

    private final TagRepository tagRepository;

    public TagServiceIMPL(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void update(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }

    @Override
    public Tag findById(int id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}
