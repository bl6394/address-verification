package com.abcfitness.addressverification.address.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "smartys_analysis")
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String dpvMatchCode;
    private String dpvFootnotes;
    @Column(name = "dpv_cmra")
    private String cmra;
    @Column(name = "dpv_vacant")
    private String vacant;
    @Column(name = "dpv_no_stat")
    private String no_stat;
    private String deprecatedActive;
    private boolean ewsMatch;
    private String footnotes;
    private String lacsLinkCode;
    private String lacsLinkIndicator;
    private boolean suiteLinkMatch;
    private String enhancedMatch;

    @OneToOne(mappedBy = "analysis")
    private Candidate candidate;

    public Analysis(){}

    public String getDpvMatchCode() {
        return dpvMatchCode;
    }

    public void setDpvMatchCode(String dpvMatchCode) {
        this.dpvMatchCode = dpvMatchCode;
    }

    public String getDpvFootnotes() {
        return dpvFootnotes;
    }

    public void setDpvFootnotes(String dpvFootnotes) {
        this.dpvFootnotes = dpvFootnotes;
    }

    public String getCmra() {
        return cmra;
    }

    public void setCmra(String cmra) {
        this.cmra = cmra;
    }

    public String getVacant() {
        return vacant;
    }

    public void setVacant(String vacant) {
        this.vacant = vacant;
    }

    public String getNo_stat() {
        return no_stat;
    }

    public void setNo_stat(String no_stat) {
        this.no_stat = no_stat;
    }

    public String getActive() {
        return deprecatedActive;
    }

    public void setActive(String active) {
        this.deprecatedActive = active;
    }

    public boolean isEwsMatch() {
        return ewsMatch;
    }

    public void setEwsMatch(boolean ewsMatch) {
        this.ewsMatch = ewsMatch;
    }

    public String getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(String footnotes) {
        this.footnotes = footnotes;
    }

    public String getLacsLinkCode() {
        return lacsLinkCode;
    }

    public void setLacsLinkCode(String lacsLinkCode) {
        this.lacsLinkCode = lacsLinkCode;
    }

    public String getLacsLinkIndicator() {
        return lacsLinkIndicator;
    }

    public void setLacsLinkIndicator(String lacsLinkIndicator) {
        this.lacsLinkIndicator = lacsLinkIndicator;
    }

    public boolean isSuiteLinkMatch() {
        return suiteLinkMatch;
    }

    public void setSuiteLinkMatch(boolean suiteLinkMatch) {
        this.suiteLinkMatch = suiteLinkMatch;
    }

    public String getEnhancedMatch() {
        return enhancedMatch;
    }

    public void setEnhancedMatch(String enhancedMatch) {
        this.enhancedMatch = enhancedMatch;
    }

    public String getDeprecatedActive() {
        return deprecatedActive;
    }

    public void setDeprecatedActive(String deprecatedActive) {
        this.deprecatedActive = deprecatedActive;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
