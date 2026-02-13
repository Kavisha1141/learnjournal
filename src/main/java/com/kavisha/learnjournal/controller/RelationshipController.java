package com.kavisha.learnjournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.kavisha.learnjournal.model.Relationship;
import com.kavisha.learnjournal.model.RelationshipRequest;
import com.kavisha.learnjournal.model.Entry;
import com.kavisha.learnjournal.repository.EntryRepository;
import com.kavisha.learnjournal.repository.RelationshipRepository;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {
    private final RelationshipRepository relationshipRepository;
    private final EntryRepository entryRepository;

    // constructor dependency injection
    public RelationshipController(RelationshipRepository relationshipRepository, EntryRepository entryRepository) {
        this.relationshipRepository = relationshipRepository;
        this.entryRepository = entryRepository;
    }

    @GetMapping
    public List<Relationship> getAll() {
        return relationshipRepository.findAll();
    }

    @PostMapping
    public Relationship createRelationship(@RequestBody RelationshipRequest request) {
        // Convert IDs from request to Entry objects
        Entry source = entryRepository.findById(request.getSourceId())
                .orElseThrow(() -> new RuntimeException("Source Entry not found"));
        Entry target = entryRepository.findById(request.getTargetId())
                .orElseThrow(() -> new RuntimeException("Target Entry not found"));

        Relationship relationship = new Relationship(source, target, request.getType());
        return relationshipRepository.save(relationship);
    }

    @GetMapping("/source/{entryId}")
    public List<Relationship> getBySource(@PathVariable Long entryId) {
        Entry source = entryRepository.findById(entryId).orElseThrow();
        return relationshipRepository.findBySource(source);
    }

}
