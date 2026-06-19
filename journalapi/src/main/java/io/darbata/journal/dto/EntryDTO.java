package io.darbata.journal.dto;

import java.time.Instant;
import java.util.UUID;

public record EntryDTO(
        UUID id,
        String authorId,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) { }
