package com.krupesh.springaigpt4.controller;

import com.krupesh.springaigpt4.service.GPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map; // Import Map

@RestController
@RequestMapping("/api/v1/gpt")
public class GPTController {

    private final GPTService gptService;

    @Autowired
    public GPTController(GPTService gptService) {
        this.gptService = gptService;
    }

    @PostMapping("/response")
    public ResponseEntity<String> getGPTResponse(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String response = gptService.getResponseFromGPT(prompt);
        return ResponseEntity.ok(response);
    }
}
