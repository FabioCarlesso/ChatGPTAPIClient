package com.fabiocarlesso;

import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Main {
    
    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "YOUR_API_KEY";

    public static void main(String[] args) throws Exception {
        Response response = new OkHttpClient()
                .newCall(getRequest(getRequestBody()))
                .execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);
        ChatGPTResponse chatGPTResponse = new Gson().fromJson(responseBody, ChatGPTResponse.class);
        if(!Objects.isNull(chatGPTResponse.getChoices())) {
            for (ChatGPTCompletion completion : chatGPTResponse.getChoices()) {
                System.out.println(completion.getText());
            }
        }
    }

    @NotNull
    private static RequestBody getRequestBody() {
        MediaType mediaType = MediaType.parse("application/json");
        return RequestBody.create(new Gson().toJson(getChatGPTRequest()), mediaType);
    }

    @NotNull
    private static Request getRequest(RequestBody body) {
        return new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    private static ChatGPTRequest getChatGPTRequest() {
        return ChatGPTRequest.builder()
                .model("text-davinci-003")
                .prompt("What am I doing here?")
                .maxTokens(4000)
                .temperature(1.0)
                .build();
    }
}