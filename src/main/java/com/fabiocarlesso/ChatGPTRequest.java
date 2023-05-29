package com.fabiocarlesso;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatGPTRequest {
    private String model;
    private String prompt;
    @JsonProperty("max_tokens")
    private int maxTokens;
    private double temperature;
}
