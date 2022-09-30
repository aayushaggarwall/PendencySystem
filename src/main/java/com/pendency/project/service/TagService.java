package com.pendency.project.service;


import com.pendency.project.models.entities.Tag;
import com.pendency.project.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
  @Autowired
  TagRepository tagRepository;

  public List<Tag> getTagsByTagNameAndTagHierarchyNumber(String tagName, Integer tagHierarchyNumber){
    return tagRepository.findByTagNameAndTagHierarchyNumber(tagName, tagHierarchyNumber);
  }

  public Tag saveTag(Tag tag){
    return tagRepository.save(tag);
  }

  public long deleteTag(Integer id){
    return tagRepository.deleteByTransactionId(id);
  }
}
