package com.spring.petclinic.aiops.observability;

import com.spring.petclinic.aiops.model.Signals;
import org.springframework.stereotype.Component;


@Component
public class PixieClient {

    public void confirm(Signals s) {
        // Real PXL integration later
        s.pixieDbFailure = false;
        s.pixieNetworkFailure = false;
    }
}
