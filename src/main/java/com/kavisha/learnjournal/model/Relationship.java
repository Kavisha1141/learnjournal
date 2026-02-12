package com.kavisha.learnjournal.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Entry source;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Entry target;

    @Enumerated(EnumType.STRING)
    private RelationshipType type;
    
    private LocalDate createdAt;

    public Relationship() {
        this.createdAt = LocalDate.now();
    }

    public Relationship(Entry source, Entry target, RelationshipType type) {
        this.target = target;
        this.source = source;
        this.type = type;
        this.createdAt = LocalDate.now();
    }

    /**
     * RETURNS: The ID of the Entry (null if not saved yet).
     */
    public Long getId() {return this.id;}

    public RelationshipType getType() { return type; }
    public Entry getSource() { return this.source; }
    public Entry getTarget() { return this.target; }
    public LocalDate getDate() {return this.createdAt;}
}
