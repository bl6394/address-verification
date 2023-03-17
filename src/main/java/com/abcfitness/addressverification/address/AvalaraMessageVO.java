package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;

public class AvalaraMessageVO {

    private String summary;
    private String details;
    private String reference;
    private String severity;
    private String source;


    public AvalaraMessageVO(String summary, String details, String reference, String severity, String source) {
        this.summary = summary;
        this.details = details;
        this.reference = reference;
        this.severity = severity;
        this.source = source;
    }

    public AvalaraMessageVO(AvalaraResponseMessage message) {
        this.summary = message.getSummary();
        this.details = message.getDetails();
        this.reference = message.getReference();
        this.severity = message.getSeverity();
        this.source = message.getSource();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
