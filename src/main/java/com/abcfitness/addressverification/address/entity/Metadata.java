package com.abcfitness.addressverification.address.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "smartys_metadata")
public class Metadata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String recordType;
    private String zipType;
    private String countyFips;
    private String countyName;
    private String carrierRoute;
    private String congressionalDistrict;
    private String buildingDefaultIndicator;
    private String rdi;
    private String elotSequence;
    private String elotSort;
    private double latitude;
    private double longitude;
    private int coordinateLicense;
    @Column(name = "coordinate_precision")
    private String precision;
    private String timeZone;
    private double utcOffset;
    private boolean obeysDst;
    private boolean ewsMatch;

    @OneToOne(mappedBy = "metadata")
    private Candidate candidate;

    public Metadata(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getZipType() {
        return zipType;
    }

    public void setZipType(String zipType) {
        this.zipType = zipType;
    }

    public String getCountyFips() {
        return countyFips;
    }

    public void setCountyFips(String countyFips) {
        this.countyFips = countyFips;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCarrierRoute() {
        return carrierRoute;
    }

    public void setCarrierRoute(String carrierRoute) {
        this.carrierRoute = carrierRoute;
    }

    public String getCongressionalDistrict() {
        return congressionalDistrict;
    }

    public void setCongressionalDistrict(String congressionalDistrict) {
        this.congressionalDistrict = congressionalDistrict;
    }

    public String getBuildingDefaultIndicator() {
        return buildingDefaultIndicator;
    }

    public void setBuildingDefaultIndicator(String buildingDefaultIndicator) {
        this.buildingDefaultIndicator = buildingDefaultIndicator;
    }

    public String getRdi() {
        return rdi;
    }

    public void setRdi(String rdi) {
        this.rdi = rdi;
    }

    public String getElotSequence() {
        return elotSequence;
    }

    public void setElotSequence(String elotSequence) {
        this.elotSequence = elotSequence;
    }

    public String getElotSort() {
        return elotSort;
    }

    public void setElotSort(String elotSort) {
        this.elotSort = elotSort;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCoordinateLicense() {
        return coordinateLicense;
    }

    public void setCoordinateLicense(int coordinateLicense) {
        this.coordinateLicense = coordinateLicense;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public double getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(double utcOffset) {
        this.utcOffset = utcOffset;
    }

    public boolean isObeysDst() {
        return obeysDst;
    }

    public void setObeysDst(boolean obeysDst) {
        this.obeysDst = obeysDst;
    }

    public boolean isEwsMatch() {
        return ewsMatch;
    }

    public void setEwsMatch(boolean ewsMatch) {
        this.ewsMatch = ewsMatch;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
