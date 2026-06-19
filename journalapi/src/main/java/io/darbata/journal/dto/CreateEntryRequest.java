package io.darbata.journal.dto;

public record CreateEntryRequest (
        String title,
        String content
) { }
