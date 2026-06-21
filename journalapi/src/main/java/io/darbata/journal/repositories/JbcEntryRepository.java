package io.darbata.journal.repositories;

import io.darbata.journal.models.EmotionClassificationResult;
import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JbcEntryRepository implements EntryRepository {

    private final JdbcClient client;
    private final JsonMapper jsonMapper;

    public JbcEntryRepository(JdbcClient client, JsonMapper jsonMapper) {
        this.client = client;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void create(Entry entry) {
        String sql = """
            INSERT INTO entries (id, author_id, title, content, created_at, updated_at)
            VALUES (:id, :authorId, :title, :content, :createdAt, :updatedAt)
        """;

        client.sql(sql)
                .param("id", entry.getId())
                .param("authorId", entry.getAuthorId().getId())
                .param("title", entry.getTitle())
                .param("content", entry.getContent())
                .param("createdAt", entry.getCreatedAt().atOffset(ZoneOffset.UTC))
                .param("updatedAt", entry.getUpdatedAt().atOffset(ZoneOffset.UTC))
                .update();
    }

    @Override
    public Optional<Entry> findById(UUID id) {
        String sql = """
            SELECT * FROM entries WHERE id = :id
        """;

        return client.sql(sql)
                .param("id", id)
                .query(new EntryRowMapper(jsonMapper))
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
                .param("from", from.atOffset(ZoneOffset.UTC))
                .param("limit", limit)
                .query(new EntryRowMapper(jsonMapper))
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
                .param("updatedAt", entry.getUpdatedAt().atOffset(ZoneOffset.UTC))
                .update();
    }

    @Override
    public void updateEmotionsById(UUID id, EmotionClassificationResult emotions) {
        String sql = """
        UPDATE entries SET emotions = :emotions::jsonb
        WHERE id = :id
    """;

        client.sql(sql)
                .param("id", id)
                .param("emotions", jsonMapper.writeValueAsString(emotions.scores()))
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

    private static class EntryRowMapper implements RowMapper<Entry> {

        private final JsonMapper jsonMapper;

        private EntryRowMapper(JsonMapper jsonMapper) {
            this.jsonMapper = jsonMapper;
        }

        @Override
        public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {


            return Entry.load(
                    rs.getObject("id", UUID.class),
                    UserID.of(rs.getString("author_id")),
                    rs.getString("title"),
                    rs.getString("content"),
                    parseEmotionsJson(rs.getString("emotions")),
                    rs.getObject("created_at", OffsetDateTime.class).toInstant(),
                    rs.getObject("updated_at", OffsetDateTime.class).toInstant()

            );
        }

        private EmotionClassificationResult parseEmotionsJson(String json) {
            if (json == null) return null;
            Map<EmotionClassificationResult.Emotion, Double> scores = jsonMapper.readValue(json, new TypeReference<>() {});
            return new EmotionClassificationResult(scores);
        }
    }
}
