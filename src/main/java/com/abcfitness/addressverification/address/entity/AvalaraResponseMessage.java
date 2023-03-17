package com.abcfitness.addressverification.address.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "avalara_response_message")
public class AvalaraResponseMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String summary;
    private String details;
    private String reference;
    private String severity;
    private String source;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "avalara_response_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    AvalaraResponse avalaraResponse;

    protected AvalaraResponseMessage (){}

    public AvalaraResponseMessage (String summary,String details, String reference, String severity, String source, AvalaraResponse avalaraResponse){
        this.summary = summary;
        this.details = details;
        this.reference = reference;
        this.severity = severity;
        this.source = source;
        this.avalaraResponse = avalaraResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AvalaraResponse getAvalaraResponse() {
        return avalaraResponse;
    }

    public void setAvalaraResponse(AvalaraResponse avalaraResponse) {
        this.avalaraResponse = avalaraResponse;
    }
}
