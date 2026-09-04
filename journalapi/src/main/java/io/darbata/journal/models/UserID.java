package io.darbata.journal.models;

public record UserID (
        String value
) {
    public UserID {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserID cannot be null");
        }
    }
}