package com.kavisha.learnjournal.controller;

import com.kavisha.learnjournal.repository.EntryRepository;
import com.kavisha.learnjournal.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @PostMapping
    public Entry createEntry(@RequestBody Entry entry) {
        return entryRepository.save(entry);
    }

    // GET by type (optional)
    @GetMapping("/type/{type}")
    public List<Entry> getByType(@PathVariable String type) {
        return entryRepository.findByType(type);
    }
}
