package io.darbata.journal.messaging;

public interface EventListener<T extends JournalEvent> {
    void handle(T event);
}