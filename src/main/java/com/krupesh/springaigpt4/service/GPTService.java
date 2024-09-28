package com.krupesh.springaigpt4.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GPTService {

    private final OpenAiService openAiService;

    @Autowired
    public GPTService(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public String getResponseFromGPT(String prompt) {
        ChatMessage userMessage = new ChatMessage("user", prompt);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-4")
                .messages(Collections.singletonList(userMessage))
                .maxTokens(100)
                .build();

        return openAiService.createChatCompletion(request).getChoices().get(0).getMessage().getContent();
    }
}
