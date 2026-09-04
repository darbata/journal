package io.darbata.journal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateEntryRequest (
        @NotBlank
        @Size(max = 32)
        String title,
        @NotBlank
        @Size(max = 2048)
        String content
) { }
