package com.krupesh.springaigpt4.config;

import com.theokanning.openai.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Value("${spring.ai.openai.api-key}") // Inject the API key from application.properties
    private String apiKey;

    @Bean
    public OpenAiService openAiService() {
        return new OpenAiService(apiKey); // Use the injected API key
    }
}
