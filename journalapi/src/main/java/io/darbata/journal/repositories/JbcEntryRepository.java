package io.darbata.journal.repositories;

import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JbcEntryRepository implements EntryRepository {

    private final JdbcClient client;

    public JbcEntryRepository(JdbcClient client) {
        this.client = client;
    }

    @Override
    public void create(Entry entry) {
        String sql = """
            INSERT INTO entries (id, author_id, title, content, created_at, updated_at)
            VALUES (:id, :authorId, :title, :content, :createdAt, :updatedAt)
        """;

        client.sql(sql)
                .param("id", entry.getId())
                .param("authorId", entry.getAuthorId())
                .param("title", entry.getTitle())
                .param("content", entry.getContent())
                .param("createdAt", entry.getCreatedAt())
                .param("updatedAt", entry.getUpdatedAt())
                .update();
    }

    @Override
    public Optional<Entry> findById(UUID id) {
        String sql = """
            SELECT * FROM entries WHERE id = :id
        """;

        return client.sql(sql)
                .param("id", id)
                .query(Entry.class)
                .optional();
    }

    // TODO: date based pagination
    @Override
    public List<Entry> findAllByUserID(UserID userID, Instant from, int limit) {
        String sql = """
            SELECT * FROM entries
            WHERE author_id = :id
            AND created_at < :from
            ORDER BY created_at DESC
            LIMIT :limit
        """;

        return client.sql(sql)
                .param("id", userID.getId())
                .param("from", from)
                .param("limit", limit)
                .query(Entry.class)
                .list();
    }

    @Override
    public void update(Entry entry) {
        String sql = """
            UPDATE entries SET title = :title, content = :content, updated_at = :updatedAt
            WHERE id = :id
        """;

        client.sql(sql)
                .param("id", entry.getId())
                .param("title", entry.getTitle())
                .param("content", entry.getContent())
                .param("updatedAt", entry.getUpdatedAt())
                .update();
    }

    @Override
    public void delete(UUID id) {
        String sql = """
            DELETE FROM entries WHERE id = :id
        """;

        client.sql(sql)
                .param("id", id)
                .update();
    }
}
