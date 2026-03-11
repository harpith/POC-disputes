package com.disputes.poc.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;
import com.disputes.poc.repository.ComplaintRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmbeddingService {
    private ComplaintRepository ComplaintRepository;
    public EmbeddingService(ComplaintRepository ComplaintRepository){
        this.ComplaintRepository=ComplaintRepository;
    }

    private final String API_URL =
            "https://router.huggingface.co/hf-inference/models/BAAI/bge-small-en-v1.5";

    private final String TOKEN = "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";



    public String getEmbedding(String text) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(TOKEN);

        try {

            Map<String, String> body = new HashMap<>();
            body.put("inputs",text);

            ObjectMapper mapper = new ObjectMapper();
            String jsonBody = mapper.writeValueAsString(body);

            System.out.println("Sending JSON to HF: " + jsonBody);

            HttpEntity<String> request =
                    new HttpEntity<>(jsonBody, headers);


            System.out.println(request);
            ResponseEntity<String> response =
                    restTemplate.postForEntity(API_URL, request, String.class);

            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling HF API";
        }
    }

    public List<Object[]> findSimilarComplaints(String text) throws Exception {

        String embeddingJson = getEmbedding(text);

        ObjectMapper mapper = new ObjectMapper();

        List<Double> embedding =
                mapper.readValue(embeddingJson, List.class);

        String vector = embedding.toString();

        return ComplaintRepository.findTop3Similar(vector);
    }
}