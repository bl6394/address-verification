package com.abcfitness.addressverification.address.feign.smartys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Analysis implements Serializable {

    private String dpvMatchCode;
    private String dpvFootnotes;
    private String cmra;
    private String vacant;
    private String no_stat;
    private String active;
    private boolean ewsMatch;
    private String footnotes;
    private String lacsLinkCode;
    private String lacsLinkIndicator;
    private boolean suiteLinkMatch;
    private String enhancedMatch;


    @JsonProperty("dpv_match_code")
    public String getDpvMatchCode() {
        return this.dpvMatchCode;
    }

    @JsonProperty("dpv_footnotes")
    public String getDpvFootnotes() {
        return this.dpvFootnotes;
    }

    @JsonProperty("dpv_cmra")
    public String getCmra() {
        return this.cmra;
    }

    @JsonProperty("dpv_vacant")
    public String getVacant() {
        return this.vacant;
    }

    @JsonProperty("dpv_no_stat")
    public String getNo_stat() { return this.no_stat; }

    @JsonProperty("active")
    public String getActive() {
        return this.active;
    }

    @JsonProperty("enhanced_match")
    public String getEnhancedMatch() {
        return this.enhancedMatch;
    }

    //@deprecated moved to metadata field
    @Deprecated
    @JsonProperty("ews_match")
    public boolean isEwsMatch() {
        return false;
    }

    @JsonProperty("footnotes")
    public String getFootnotes() {
        return this.footnotes;
    }

    @JsonProperty("lacslink_code")
    public String getLacsLinkCode() {
        return this.lacsLinkCode;
    }

    @JsonProperty("lacslink_indicator")
    public String getLacsLinkIndicator() {
        return this.lacsLinkIndicator;
    }

    @JsonProperty("suitelink_match")
    public boolean isSuiteLinkMatch() {
        return this.suiteLinkMatch;
    }

}
