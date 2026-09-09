package io.darbata.journal.messaging;

public interface EventPublisher {
    void publish(JournalEvent event);
}