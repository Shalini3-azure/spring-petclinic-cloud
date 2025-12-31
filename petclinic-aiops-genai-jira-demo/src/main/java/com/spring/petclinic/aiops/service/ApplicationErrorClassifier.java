package com.spring.petclinic.aiops.service;

import com.spring.petclinic.aiops.model.Signals;
import org.springframework.stereotype.Component;

@Component
public class ApplicationErrorClassifier {

    public boolean isPureApplication(Signals s) {
        return "PRE_DEPENDENCY".equals(s.errorStage)
            && !s.pixieDbFailure
            && !s.cpuHotspot;
    }
}