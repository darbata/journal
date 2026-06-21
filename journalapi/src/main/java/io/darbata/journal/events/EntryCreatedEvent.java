package io.darbata.journal.events;

import java.util.UUID;

public record EntryCreatedEvent(
        UUID entryId
) {
    public static EntryCreatedEvent from (UUID entryId) {
        return new EntryCreatedEvent(entryId);
    }

    @Override
    public String toString() {
        return "EntryCreatedEvent{" +
                "entryId=" + entryId +
                '}';
    }
}
