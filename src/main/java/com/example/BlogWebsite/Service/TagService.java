package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.Tag;

import java.util.List;

public interface TagService {
    void save(Tag tag);

    void update(Tag tag);

    void delete(Tag tag);

    Tag findById(int id);

    List<Tag> findAll();
}
