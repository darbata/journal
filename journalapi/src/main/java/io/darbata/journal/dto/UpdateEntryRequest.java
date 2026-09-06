package io.darbata.journal.dto;

import jakarta.validation.constraints.Size;

public record UpdateEntryRequest (
    @Size(max = 32)
    String title,
    @Size(max = 2048)
    String content
) {}
