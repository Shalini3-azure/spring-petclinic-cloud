package com.spring.petclinic.aiops.service;

import com.spring.petclinic.aiops.model.Issue;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class JiraService {

    // Deduplication set
    private static final Set<String> DEDUPE = new HashSet<>();

    /**
     * Creates Jira ticket if not duplicated
     */
    public void create(Issue issue) {
        String key = issue.getService() + issue.getEndpoint() + issue.getLevel();
        if (DEDUPE.contains(key)) return; // Skip duplicates
        DEDUPE.add(key);

        // TODO: Call Jira REST API using configured token
        System.out.println("JIRA CREATED -> " + issue);
    }
}
