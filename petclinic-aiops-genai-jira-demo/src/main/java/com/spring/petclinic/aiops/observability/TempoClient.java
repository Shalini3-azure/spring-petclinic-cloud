package com.spring.petclinic.aiops.observability;

import com.spring.petclinic.aiops.model.Signals;
import org.springframework.stereotype.Component;


@Component
public class TempoClient {
    public void detect(Signals s) {
        // TODO: Query Tempo for last 30 min
        s.endpointExists = true;
        s.exceptionType = "NullPointerException";
        s.errorStage = "PRE_DEPENDENCY";
        s.errorCount = 25;
        s.p95Latency = 1800;
    }
}
