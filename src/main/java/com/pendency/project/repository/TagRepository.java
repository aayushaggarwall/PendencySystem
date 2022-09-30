package com.pendency.project.repository;


import com.pendency.project.models.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TagRepository extends CrudRepository<Tag, Long>
{
  List<Tag> findByTagNameAndTagHierarchyNumber (String tagName, Integer tagHierarchyNumber);

  long deleteByTransactionId(Integer transactionId);
}
