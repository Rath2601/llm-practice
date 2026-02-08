package com.rath.practice.utility;

import org.springframework.stereotype.Component;

@Component
public class PromptTemplate {
    public static String analyseResume(String resumeText, String jobDesc) {
        return """
                You are an experienced Technical recruiter.
                
                Analyze the following resume against the job description.
                
                Resume:
                %s
                
                Job Description:
                %s
                
                Provide:
                1. Skill match percentage
                2. Missing skills
                3. Strengths
                4. Weaknesses
                5. Improvement suggestions
                """.formatted(resumeText, jobDesc);
    }
}
