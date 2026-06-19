package io.darbata.journal.repositories;

import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
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
        String query = """
            SELECT * FROM entries WHERE author_id = :id
        """;

        return client.sql(query)
                .param("id", userID.getId())
                .query(Entry.class)
                .list();
    }

    @Override
    public Entry update(Entry entry) {
        return null;
    }

    @Override
    public void delete(Entry entry) {

    }
}
