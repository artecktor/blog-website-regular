package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.DTO.BlogShowDTO;
import com.example.BlogWebsite.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
