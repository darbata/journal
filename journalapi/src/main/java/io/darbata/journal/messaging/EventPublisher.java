package io.darbata.journal.messaging;

interface EventPublisher {
    void publish(JournalEvent event);
}