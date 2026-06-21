package io.darbata.journal.amqp;

import io.darbata.journal.events.EntryCreatedEvent;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JournalEventSender {


    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    public JournalEventSender(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    public void sendEntryCreatedEvent(EntryCreatedEvent event) {
        amqpTemplate.convertAndSend("entries.created", event);
    }

}
