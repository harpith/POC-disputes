package com.disputes.poc.controller;

import com.disputes.poc.service.EmbeddingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmbeddingController {

    private final EmbeddingService embeddingService;

    public EmbeddingController(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @PostMapping("/embedding")
    public String getEmbedding(@RequestBody Map<String,String> request) {
        String text=request.get("text");
        System.out.println(text);
        return embeddingService.getEmbedding(text);
    }

    @PostMapping("/similar")
    public List<Object[]> similar(@RequestBody Map<String,String> request) throws Exception{
        String text=request.get("text");
        return embeddingService.findSimilarComplaints(text);
    }
}