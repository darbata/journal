package io.darbata.journal.config;

import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.MapperFeature;

@Configuration
public class JacksonConfig {

    @Bean
    JsonMapperBuilderCustomizer mapper() {
        return builder ->
                builder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
    }


}
