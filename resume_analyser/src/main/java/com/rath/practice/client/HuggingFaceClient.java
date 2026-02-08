package com.rath.practice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;


@Component
public class HuggingFaceClient {
    private final WebClient webClient;
    private final String model;
    public HuggingFaceClient(WebClient.Builder builder,
                             @Value("${huggingface.api.token}") String token ,
                             @Value("${huggingface.api.model}") String model){
        this.model = model;
        this.webClient = builder.baseUrl("https://router.huggingface.co/hf-inference/models/").defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ token).build();
    }

    public String query(String prompt) {
        return webClient.post()
                .uri(model)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("inputs", prompt))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
