package com.spring.petclinic.aiops.service;

import com.spring.petclinic.aiops.model.Severity;
import com.spring.petclinic.aiops.model.Signals;
import org.springframework.stereotype.Component;

@Component
public class SeverityCalculator {

    public Severity calculate(Signals s) {
        if (s.errorCount > 30) return Severity.CRITICAL;
        if (s.errorCount > 20) return Severity.HIGH;
        if (s.p95Latency > 3000) return Severity.MEDIUM;
        return Severity.LOW;
    }
}
