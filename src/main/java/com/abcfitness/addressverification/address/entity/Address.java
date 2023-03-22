package com.abcfitness.addressverification.address.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String clubNumber;
    private String active;
    private String clubName;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String plus4;

    @OneToMany(mappedBy="address")
    private Set<Candidate> candidates;

    protected Address(){}

    public Address(String clubName, String clubNumber, String active, String line1, String line2, String city, String state, String zip, String plus4) {
        this.clubName = clubName;
        this.clubNumber = clubNumber;
        this.active = active;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.plus4 = plus4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String club) {
        this.clubName = club;
    }

    public String getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(String clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPlus4() {
        return plus4;
    }

    public void setPlus4(String plus4) {
        this.plus4 = plus4;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

//    public Corrected getCorrected() {
//        return corrected;
//    }
//
//    public void setCorrected(Corrected corrected) {
//        this.corrected = corrected;
//    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }
}