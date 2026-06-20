package io.darbata.journal.dto;

import io.darbata.journal.models.EmotionClassificationResult;

import java.time.Instant;
import java.util.UUID;

public record EntryDTO(
        UUID id,
        String authorId,
        String title,
        String content,
        EmotionClassificationResult scores,
        Instant createdAt,
        Instant updatedAt
) { }
