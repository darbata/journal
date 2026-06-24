package io.darbata.journal.dto;

import io.darbata.journal.models.Emotion;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record EntryDTO(
        UUID id,
        String authorId,
        String title,
        String content,
        Map<Emotion, Double> scores,
        Instant createdAt,
        Instant updatedAt
) { }
