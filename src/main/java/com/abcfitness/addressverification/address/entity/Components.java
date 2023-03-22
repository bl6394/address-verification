package com.abcfitness.addressverification.address.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "smartys_components")
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String urbanization;
    private String primaryNumber;
    private String streetName;
    private String streetPredirection;
    private String streetPostdirection;
    private String streetSuffix;
    private String secondaryNumber;
    private String secondaryDesignator;
    private String extraSecondaryNumber;
    private String extraSecondaryDesignator;
    private String pmbDesignator;
    private String pmbNumber;
    private String cityName;
    private String defaultCityName;
    @Column(name = "state_abbreviation")
    private String state;
    @Column(name = "zipcode")
    private String zipCode;
    @Column(name = "plus4_code")
    private String plus4Code;
    private String deliveryPoint;
    private String deliveryPointCheckDigit;

    @OneToOne(mappedBy = "components")
    private Candidate candidate;

    public Components(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrbanization() {
        return urbanization;
    }

    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetPredirection() {
        return streetPredirection;
    }

    public void setStreetPredirection(String streetPredirection) {
        this.streetPredirection = streetPredirection;
    }

    public String getStreetPostdirection() {
        return streetPostdirection;
    }

    public void setStreetPostdirection(String streetPostdirection) {
        this.streetPostdirection = streetPostdirection;
    }

    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public String getSecondaryNumber() {
        return secondaryNumber;
    }

    public void setSecondaryNumber(String secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }

    public String getSecondaryDesignator() {
        return secondaryDesignator;
    }

    public void setSecondaryDesignator(String secondaryDesignator) {
        this.secondaryDesignator = secondaryDesignator;
    }

    public String getExtraSecondaryNumber() {
        return extraSecondaryNumber;
    }

    public void setExtraSecondaryNumber(String extraSecondaryNumber) {
        this.extraSecondaryNumber = extraSecondaryNumber;
    }

    public String getExtraSecondaryDesignator() {
        return extraSecondaryDesignator;
    }

    public void setExtraSecondaryDesignator(String extraSecondaryDesignator) {
        this.extraSecondaryDesignator = extraSecondaryDesignator;
    }

    public String getPmbDesignator() {
        return pmbDesignator;
    }

    public void setPmbDesignator(String pmbDesignator) {
        this.pmbDesignator = pmbDesignator;
    }

    public String getPmbNumber() {
        return pmbNumber;
    }

    public void setPmbNumber(String pmbNumber) {
        this.pmbNumber = pmbNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDefaultCityName() {
        return defaultCityName;
    }

    public void setDefaultCityName(String defaultCityName) {
        this.defaultCityName = defaultCityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPlus4Code() {
        return plus4Code;
    }

    public void setPlus4Code(String plus4Code) {
        this.plus4Code = plus4Code;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public String getDeliveryPointCheckDigit() {
        return deliveryPointCheckDigit;
    }

    public void setDeliveryPointCheckDigit(String deliveryPointCheckDigit) {
        this.deliveryPointCheckDigit = deliveryPointCheckDigit;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
