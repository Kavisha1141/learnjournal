package com.kavisha.learnjournal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
//   private ArrayList<String> tags;

    private String type;

    private boolean imp = false;
    private LocalDate date;

    public Entry() {
    this.date = LocalDate.now();
    }

    public Entry(String title, String content, String type) {
        this.title = title;
        this.content = content;
//        tags = new ArrayList<>();
        this.type = type;
        imp = false;
        date = LocalDate.now();
    }


    /**
     * RETURNS: The ID of the Entry (null if not saved yet).
     */
    public Long getId() {
        return this.id;
    }

    public String getType() { return type; }
    public String getTitle() {
        return this.title;
    }

    public void setType(String type) { this.type = type; }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public void addContent(String newContent) {
        this.content = this.content + " " + newContent;
    }

    // public ArrayList<String> getTags() {
    //     return tags;
    // }

    // public void addTag(String tag) {
    //     this.tags.add(tag);
    // }

    public boolean isImportant() {
        return this.imp;
    }
    
    public void markImportant() {
        this.imp = true;
    }

    public void markNotImportant() {
        this.imp = false;
    }

    public LocalDate getDate() {
        return this.date;
    }

}

