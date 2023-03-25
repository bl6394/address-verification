package com.abcfitness.addressverification.address.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "avalara_tax_authority")
public class AvalaraTaxAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String avalaraId;
    private String jurisdictionName;
    private String jurisdictionType;
    private String signatureCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "avalara_response_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    AvalaraResponse avalaraResponse;

    protected AvalaraTaxAuthority(){}

    public AvalaraTaxAuthority(String avalaraId, String jurisdictionName, String jurisdictionType, String signatureCode, AvalaraResponse avalaraResponse){
        this.avalaraId = avalaraId;
        this.jurisdictionName = jurisdictionName;
        this.jurisdictionType = jurisdictionType;
        this.signatureCode = signatureCode;
        this.avalaraResponse = avalaraResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvalaraId() {
        return avalaraId;
    }

    public void setAvalaraId(String avalaraId) {
        this.avalaraId = avalaraId;
    }

    public String getJurisdictionName() {
        return jurisdictionName;
    }

    public void setJurisdictionName(String jurisdictionName) {
        this.jurisdictionName = jurisdictionName;
    }

    public String getJurisdictionType() {
        return jurisdictionType;
    }

    public void setJurisdictionType(String jurisdictionType) {
        this.jurisdictionType = jurisdictionType;
    }

    public String getSignatureCode() {
        return signatureCode;
    }

    public void setSignatureCode(String signatureCode) {
        this.signatureCode = signatureCode;
    }

    public AvalaraResponse getAvalaraResponse() {
        return avalaraResponse;
    }

    public void setAvalaraResponse(AvalaraResponse avalaraResponse) {
        this.avalaraResponse = avalaraResponse;
    }
}
