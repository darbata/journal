package io.darbata.journal.repositories;

import io.darbata.journal.model.Entry;
import io.darbata.journal.model.UserID;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JbcEntryRepository implements EntryRepository {

    private final JdbcClient client;

    public JbcEntryRepository(JdbcClient client) {
        this.client = client;
    }

    @Override
    public Entry create(Entry entry) {
        return null;
    }

    @Override
    public Entry findById(String id) {
        return null;
    }

    @Override
    public List<Entry> findAllByUserID(UserID userID) {
        return List.of();
    }

    @Override
    public Entry update(Entry entry) {
        return null;
    }

    @Override
    public void delete(Entry entry) {

    }
}
