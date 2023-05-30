package com.fabiocarlesso;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatGPTResponse {
    private ChatGPTCompletion[] choices;
}
