package io.darbata.journal.messaging;

import io.darbata.journal.exceptions.PublishEventFailedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.MessageAttributeValue;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Component
public class SnsEventPublisher implements EventPublisher {

    @Value("${journal.messaging.topicArn}")
    String topicArn;
    final String TYPE = "event_type";

    final SnsClient client;
    final ObjectMapper mapper;

    public SnsEventPublisher(SnsClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public String publish(JournalEvent event) {

        // serialise to json
        String body;
        try {
            body = mapper.writeValueAsString(event);
        } catch (JacksonException e) {
            throw new PublishEventFailedException(e.getMessage());
        }

        PublishRequest request = PublishRequest.builder()
                .message(body)
                .topicArn(topicArn)
                .messageAttributes(Map.of( // what SNS can see and filter on
                        TYPE, // enable SNS to filter on type of event
                        MessageAttributeValue.builder().dataType("String").stringValue(event.type()).build())
                )
                .build();

        // publish to SNS topic
        try { // if message id returned then SNS received
            return client.publish(request).messageId();
        } catch (SdkException e) {
            throw new PublishEventFailedException("publish" + event.type() + e.rawMessage());
        }
    }
}