package io.darbata.journal.models;

import java.time.Instant;
import java.util.UUID;

public class Entry {

    private final UUID id;
    private final UserID authorId;
    private String title;
    private String content;
    private final Instant createdAt;
    private Instant updatedAt;

    private Entry(
            UUID id, UserID authorId, String title, String content, Instant createdAt, Instant updatedAt
    ) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Entry create(UserID authorId, String title, String content) {
        UUID id = UUID.randomUUID();
        return new Entry(id, authorId, title, content, Instant.now(), Instant.now());
    }

    public Entry load(
            UUID id, UserID authorId, String title, String content, Instant createdAt, Instant updatedAt
    ) {
        return new Entry(id, authorId, title, content, createdAt, updatedAt);
    }

    public UUID getId() {
        return id;
    }

    public UserID getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}
