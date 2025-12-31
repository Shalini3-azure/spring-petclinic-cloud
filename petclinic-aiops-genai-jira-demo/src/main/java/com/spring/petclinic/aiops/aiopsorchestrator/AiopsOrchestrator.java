package com.spring.petclinic.aiops.aiopsorchestrator;

import com.spring.petclinic.aiops.service.ApplicationErrorClassifier;
import com.spring.petclinic.aiops.service.GenAIService;
import com.spring.petclinic.aiops.service.JiraService;
import com.spring.petclinic.aiops.service.SeverityCalculator;
import lombok.RequiredArgsConstructor;
import com.spring.petclinic.aiops.model.*;
import com.spring.petclinic.aiops.observability.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiopsOrchestrator {

    private final TempoClient tempo;
    private final PixieClient pixie;
    private final ParcaClient parca;
    private final ApplicationErrorClassifier classifier;
    private final SeverityCalculator severity;
    private final GenAIService genai;
    private final JiraService jira;

    public Issue analyze() {

        Signals s = new Signals();
        tempo.detect(s);
        pixie.confirm(s);
        parca.confirm(s);

        Issue issue = new Issue();
        issue.setService("petclinic");
        issue.setEndpoint("dynamic");

        if (classifier.isPureApplication(s)) {
            issue.setSource("OPENTELEMETRY");
            issue.setLevel("APPLICATION");
            issue.setAssignee("Ms Gana");
        } else if (s.pixieDbFailure) {
            issue.setSource("PIXIE");
            issue.setLevel("SERVICE");
            issue.setAssignee("Mr Vivek");
        } else if (s.cpuHotspot) {
            issue.setSource("PARCA");
            issue.setLevel("SYSTEM");
            issue.setAssignee("Mr Abhishek");
        } else {
            return null;
        }

        issue.setSeverity(severity.calculate(s));
        genai.enrich(issue);
        jira.create(issue);

        return issue;
    }
}
