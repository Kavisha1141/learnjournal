package com.kavisha.learnjournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

import com.kavisha.learnjournal.model.Relationship;
import com.kavisha.learnjournal.model.RelationshipRequest;
import com.kavisha.learnjournal.model.RelationshipResponse;
import com.service.RelationshipService;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {

    private final RelationshipService service;

    // constructor dependency injection
    public RelationshipController(RelationshipService service) {
        this.service = service;
    }

    // RETURNS: List of all relationships.
    @GetMapping
    public List<RelationshipResponse> getAll() {
        return service.getAll().stream()
                  .map(RelationshipResponse::fromEntity)
                  .collect(Collectors.toList());
    }

    /**
     * REQUIRES:
     * - sourceId and targetId in the request must refer to existing Entries.
     * - type must not be null.
     *
     * MODIFIES:
     * - Saves a new Relationship in the database.
     *
     * RETURNS:
     * - The saved Relationship with generated ID.
     */
    @PostMapping
    public RelationshipResponse createRelationship(@RequestBody RelationshipRequest request) {
        Relationship relationship = service.createRelationship(request);
        return RelationshipResponse.fromEntity(relationship);
    }

     /**
     * REQUIRES:Source id of the request exists.
     * MODIFIES: Nothing.
     * RETURNS: List of relationships where the Entry is the source.
     */
    @GetMapping("/source/{entryId}")
    public List<RelationshipResponse> getBySource(@PathVariable Long entryId) {
        return service.getBySource(entryId).stream()
                .map(RelationshipResponse::fromEntity)
                .collect(Collectors.toList());
    }

}
