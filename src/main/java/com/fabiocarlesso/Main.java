package com.fabiocarlesso;

import okhttp3.*;
import org.json.JSONObject;

public class Main {
    
    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "YOUR_API_KEY";

    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String prompt = "My name is";
        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", prompt);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        RequestBody body = RequestBody.create(data.toString(), mediaType);

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        System.out.println(responseBody);
    }
}