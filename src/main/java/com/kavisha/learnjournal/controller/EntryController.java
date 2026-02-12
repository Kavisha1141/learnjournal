package com.kavisha.learnjournal.controller;

import com.kavisha.learnjournal.repository.EntryRepository;
import com.kavisha.learnjournal.model.Entry;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // handles HTTP requests and returns JSON
@RequestMapping("/entries") // defines the base URL
public class EntryController {

    private final EntryRepository entryRepository;

    // constructor dependency injection
    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    /**
     * REQUIRES: Database connection is available.
     * MODIFIES: Nothing.
     * RETURNS: List of all entries. Empty if none exist.
     */
    @GetMapping
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    /**
     * REQUIRES: Valid Entry object in request body.
     * MODIFIES: Saves the Entry to the database.
     * RETURNS: The saved Entry with generated ID.
     */
    @PostMapping
    public Entry createEntry(@RequestBody Entry entry) {
        return entryRepository.save(entry);
    }

    /**
     * REQUIRES: Type string is provided in path.
     * MODIFIES: Nothing.
     * RETURNS: List of entries with the given type. Empty if none found.
     */
    // GET by type (optional)
    @GetMapping("/type/{type}")
    public List<Entry> getByType(@PathVariable String type) {
        return entryRepository.findByType(type);
    }
}
