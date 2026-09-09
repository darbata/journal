package io.darbata.journal.messaging;

import java.time.Instant;

public record EntryCreatedEvent (String entryId, Instant occurredAt, String authorId) implements JournalEvent {
    @Override
    public String type() {
        return "journal.entry.created";
    }
}
