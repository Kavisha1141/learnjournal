package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kavisha.learnjournal.repository.EntryRepository;
import com.kavisha.learnjournal.repository.RelationshipRepository;
import com.kavisha.learnjournal.model.RelationshipRequest;
import com.kavisha.learnjournal.model.Entry;
import com.kavisha.learnjournal.model.Relationship;


@Service
public class RelationshipService {
    
    @Autowired
    private EntryRepository entryRepository;
    
    @Autowired
    private RelationshipRepository relationshipRepository;

    public List<Relationship> getAll() {
        return relationshipRepository.findAll();
    }

    public Relationship createRelationship(RelationshipRequest request) {
        Entry source = entryRepository.findById(request.getSourceId())
            .orElseThrow(() -> new RuntimeException("Source Entry not found"));
        Entry target = entryRepository.findById(request.getTargetId())
            .orElseThrow(() -> new RuntimeException("Target Entry not found"));
        if (request.getSourceId() == request.getTargetId())
            throw new RuntimeException("Source Entry same as Target Entry");

        Relationship relationship = new Relationship(source, target, request.getType());
        return relationshipRepository.save(relationship);
    }

    public List<Relationship> getBySource(Long entryId) {
        Entry source = entryRepository.findById(entryId).orElseThrow();
        return relationshipRepository.findBySource(source);
    }
}
