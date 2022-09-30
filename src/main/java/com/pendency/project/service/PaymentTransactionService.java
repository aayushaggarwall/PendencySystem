package com.pendency.project.service;

import com.pendency.project.models.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentTransactionService {

  @Autowired
  TagService tagService;

  public void startTracking(Integer id, List<String> hierarchicalTags){
    for(int i=0; i<hierarchicalTags.size(); i++){
      tagService.saveTag(new Tag(id, hierarchicalTags.get(i), i));
    }
  }

  public void stopTracking(Integer id){
    tagService.deleteTag(id);
  }

  public Integer getCounts (List<String> tags){

    HashSet<Integer> finalSet = null;
    for(int i=0; i<tags.size(); i++){
      List<Tag> tagList = tagService.getTagsByTagNameAndTagHierarchyNumber(tags.get(i), i);

      HashSet<Integer> setofTransactionId = (HashSet<Integer>) tagList.stream().map(Tag::getTransactionId).collect(Collectors.toSet());

      if(finalSet == null){
        finalSet = setofTransactionId;
      }
      else {
        finalSet.retainAll(setofTransactionId);
      }
    }
    return finalSet.size();
  }
}
