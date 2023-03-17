package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Corrected;

public class CorrectedVO {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String plus4;

    public CorrectedVO(Corrected corrected) {
        this.line1 = corrected.getLine1();
        this.line2 = corrected.getLine2();
        this.city = corrected.getCity();
        this.state = corrected.getState();
        this.zip = corrected.getZip();
        this.plus4 = corrected.getPlus4();
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
}
