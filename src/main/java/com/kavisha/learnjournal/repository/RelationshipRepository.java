package com.kavisha.learnjournal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavisha.learnjournal.model.Entry;
import com.kavisha.learnjournal.model.Relationship;
import com.kavisha.learnjournal.model.RelationshipType;


public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
   
    // Get all relationships where a given Entry is the source
    List<Relationship> findBySource(Entry source);

    // Get all relationships where a given Entry is the target
    List<Relationship> findByTarget(Entry target);

    // Optional: find relationships by type
    List<Relationship> findByType(RelationshipType type);
}
