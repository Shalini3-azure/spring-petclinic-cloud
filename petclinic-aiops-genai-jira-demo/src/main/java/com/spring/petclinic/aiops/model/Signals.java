package com.spring.petclinic.aiops.model;
import lombok.Data;
@Data
public class Signals {
    public boolean endpointExists;
    public String exceptionType;
    public String errorStage;
    public int errorCount;
    public long p95Latency;
    public boolean pixieDbFailure;
    public boolean pixieNetworkFailure;
    public boolean cpuHotspot;
    public boolean gcPressure;
}
