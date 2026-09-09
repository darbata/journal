package io.darbata.journal.messaging;

public interface EventPublisher {
    String publish(JournalEvent event);
}