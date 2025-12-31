package com.spring.petclinic.aiops.observability;

import com.spring.petclinic.aiops.model.Signals;
import org.springframework.stereotype.Component;




@Component
public class ParcaClient {
    public void confirm(Signals s) {
        // TODO: Query Parca for CPU/GC hotspots
        s.cpuHotspot = false;
        s.gcPressure = false;
    }
}
