package io.darbata.journal.messaging;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class JournalEventSender {

    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    public JournalEventSender(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

}
