package com.rath.practice.service;

import com.rath.practice.client.HuggingFaceClient;
import com.rath.practice.utility.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResumeAnalysisService {
    private final HuggingFaceClient huggingFaceClient;
    public ResumeAnalysisService(HuggingFaceClient huggingFaceClient){
        this.huggingFaceClient = huggingFaceClient;
    }
    public String analyze(String resume, String jonDesc){
        String prompt = PromptTemplate.analyseResume(resume, jonDesc);
        return huggingFaceClient.query(prompt);
    }
}
