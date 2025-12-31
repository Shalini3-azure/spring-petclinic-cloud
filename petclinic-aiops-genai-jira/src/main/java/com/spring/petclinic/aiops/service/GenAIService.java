package com.spring.petclinic.aiops.service;

import com.spring.petclinic.aiops.model.Issue;
import org.springframework.stereotype.Component;

@Component
public class GenAIService {

    /**
     * Enriches the issue with explanation and suggested fix
     */
    public void enrich(Issue issue) {
        // Call your GenAI Nexus endpoint here with API Key
        // For demo, we use placeholder explanation
        issue.setFix("GenAI explanation and suggested remediation for the issue.");
    }
}
