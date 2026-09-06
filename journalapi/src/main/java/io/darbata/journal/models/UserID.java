package io.darbata.journal.models;

import java.util.Objects;

public record UserID (
        String value
) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserID userID = (UserID) o;
        return Objects.equals(value, userID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public UserID {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserID cannot be null");
        }


    }
}