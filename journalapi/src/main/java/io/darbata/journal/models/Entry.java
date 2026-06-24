package io.darbata.journal.models;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Entry {

    private final UUID id;
    private final UserID authorId;
    private String title;
    private String content;
    private final Emotion dominant;
    private Map<Emotion, Double> emotions;
    private final boolean analysed;
    private final Instant createdAt;
    private Instant updatedAt;

    private Entry(
            UUID id, UserID authorId, String title, String content, Emotion dominant, Map<Emotion, Double> emotions,
            boolean analysed, Instant createdAt, Instant updatedAt
    ) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.dominant = dominant;
        this.emotions = emotions;
        this.analysed = analysed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Entry create(UserID authorId, String title, String content) {
        UUID id = UUID.randomUUID();
        return new Entry(id, authorId, title, content, Emotion.NONE, new HashMap<>(), false, Instant.now(), Instant.now());
    }

    public static Entry load(
            UUID id, UserID authorId, String title, String content, Map<Emotion, Double> emotions,
            Instant createdAt, Instant updatedAt
    ) {

        if (emotions == null) { emotions = new HashMap<>(); }

        Emotion dominant = Emotion.NONE;

        if (!emotions.isEmpty()) {
            double maxScore = Double.MIN_VALUE;

            for (var score : emotions.entrySet()) {
                if (maxScore < score.getValue()) {
                    maxScore = score.getValue();
                    dominant = score.getKey();
                }
            }
        }

        return new Entry(id, authorId, title, content, dominant, emotions, !emotions.isEmpty(), createdAt, updatedAt);

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

    public Emotion getDominant() {
        return dominant;
    }

    public Map<Emotion, Double> getEmotions() {
        return emotions;
    }

    public void setEmotions(Map<Emotion, Double> emotions) {
        this.emotions = emotions;
    }

    public boolean isAnalysed() {
        return analysed;
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
