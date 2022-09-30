package com.pendency.project.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
  @Id
  @GeneratedValue(strategy
      = GenerationType.AUTO)
  long id;

  @Column
  Integer transactionId;

  @Column
  Integer tagHierarchyNumber;

  @Column
  String tagName;

  public Tag(Integer transactionId, String tagName, Integer tagHierarchyNumber){
    this.transactionId = transactionId;
    this.tagName = tagName;
    this.tagHierarchyNumber = tagHierarchyNumber;
  }
}
