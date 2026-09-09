package io.darbata.journal.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
class SnsConfiguration {
    @Bean
    SnsClient snsClientBuilder() {
        return SnsClient.builder().build();
    }
}