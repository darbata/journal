package io.darbata.journal.repositories;

import io.darbata.journal.model.Entry;
import io.darbata.journal.model.UserID;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository {
    Entry create(Entry entry);
    Entry findById(String id);
    List<Entry> findAllByUserID(UserID userID);
    Entry update(Entry entry);
    void delete(Entry entry);
}