package com.spring.petclinic.aiops.aiopscontroller;

import com.spring.petclinic.aiops.aiopsorchestrator.AiopsOrchestrator;
import com.spring.petclinic.aiops.model.Issue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aiops")
@RequiredArgsConstructor
public class AiopsController {

    private final AiopsOrchestrator orchestrator;

    /**
     * POST /aiops/analyze
     * Triggers analysis of last 30 min traces
     */
    @PostMapping("/analyze")
    public Issue analyze() {
        return orchestrator.analyze();
    }
}
