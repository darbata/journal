package io.darbata.journal.dto;

import java.util.UUID;

public record EntryContentDTO (
        UUID id,
        String content
) { }
