package io.darbata.journal.amqp;

import io.darbata.journal.events.ClassificationEvent;
import io.darbata.journal.services.EntryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JournalEventReceiver {

    private final EntryService entryService;

    public JournalEventReceiver(EntryService entryService) {
        this.entryService = entryService;
    }

    @RabbitListener(queues="entries.classifications")
    public void processEmotionClassification(ClassificationEvent event) {

        entryService.assignEmotionsById(
                event.entryId(),
                event.scores()
        );

    }

}
