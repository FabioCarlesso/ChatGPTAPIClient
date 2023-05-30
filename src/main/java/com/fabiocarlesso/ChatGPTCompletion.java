package com.fabiocarlesso;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatGPTCompletion {
    private String text;
    private int index;
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;
}
