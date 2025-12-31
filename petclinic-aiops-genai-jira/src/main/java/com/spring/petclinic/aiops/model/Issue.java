package com.spring.petclinic.aiops.model;

import lombok.Data;

@Data
public class Issue {
    private String source;      // OT / Pixie / Parca
    private String level;       // Application / Service / System
    private String service;     // e.g., customers-service
    private String endpoint;    // e.g., GET /api/customer/owners
    private Severity severity;
    private String assignee;    // Developer / DevOps / Platform
    private String summary;     // Short issue summary
    private String fix;         // GenAI suggested fix
}


