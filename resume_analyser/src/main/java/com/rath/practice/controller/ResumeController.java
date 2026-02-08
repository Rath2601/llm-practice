package com.rath.practice.controller;

import com.rath.practice.domain.ResumeRequest;
import com.rath.practice.service.ResumeAnalysisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
    private final ResumeAnalysisService resumeAnalysisService;
    public ResumeController(ResumeAnalysisService resumeAnalysisService){
        this.resumeAnalysisService = resumeAnalysisService;
    }
    @PostMapping("/analyze")
    public String analyze(@RequestBody ResumeRequest resumeRequest){
        return resumeAnalysisService.analyze(resumeRequest.resume(), resumeRequest.jobDescription());
    }
}
