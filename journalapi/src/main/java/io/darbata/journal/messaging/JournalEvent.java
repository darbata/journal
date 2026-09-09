package io.darbata.journal.messaging;

import java.time.Instant;

public sealed interface JournalEvent permits EntryCreatedEvent {
    String type(); // must override
    String entryId();
    Instant occurredAt();
}