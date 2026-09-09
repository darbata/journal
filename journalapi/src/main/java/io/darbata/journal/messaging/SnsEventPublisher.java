package io.darbata.journal.messaging;

import org.springframework.stereotype.Component;

@Component
public class SnsEventPublisher implements EventPublisher {
    @Override
    public void publish(JournalEvent event) {}
}
