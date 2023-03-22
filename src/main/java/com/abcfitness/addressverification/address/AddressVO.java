package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;

import java.util.List;
import java.util.stream.Collectors;

public class AddressVO {

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
    private List<AvalaraMessageVO> messages;

    public AddressVO (Address address, List<AvalaraResponseMessage> messages){
        this.id = address.getId();
        this.clubNumber = address.getClubNumber();
        this.clubName = address.getClubName();
        this.active = address.getActive();
        this.line1 = address.getLine1();
        this.line2 = address.getLine2();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
        this.plus4 = address.getPlus4();
        this.messages = messages.stream().map(element -> new AvalaraMessageVO(element)).collect(Collectors.toList());
    }

    public String getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(String clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
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

    public List<AvalaraMessageVO> getMessages() {
        return messages;
    }

    public void setMessages(List<AvalaraMessageVO> messages) {
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
