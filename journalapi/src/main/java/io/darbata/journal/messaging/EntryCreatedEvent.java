package io.darbata.journal.messaging;

import org.apache.logging.log4j.CloseableThreadContext;

public record EntryCreatedEvent (String entryId, CloseableThreadContext.Instance occurredAt) implements JournalEvent  {
    @Override
    public String type() {
        return "journal..entry.created";
    }
}
