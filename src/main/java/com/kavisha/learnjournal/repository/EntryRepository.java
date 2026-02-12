package com.kavisha.learnjournal.repository;


import com.kavisha.learnjournal.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByType(String type);
}
