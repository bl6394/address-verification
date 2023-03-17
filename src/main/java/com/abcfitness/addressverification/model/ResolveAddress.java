package com.abcfitness.addressverification.model;

import java.util.ArrayList;
import java.util.List;

public class ResolveAddress {

    private Address address;
    private Coordinates coordinates;
    private String resolutionQuality;
    private List<TaxAuthorities> taxAuthorities;
    List<Message> messages;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getResolutionQuality() {
        return resolutionQuality;
    }

    public void setResolutionQuality(String resolutionQuality) {
        this.resolutionQuality = resolutionQuality;
    }

    public List<TaxAuthorities> getTaxAuthorities() {
        return taxAuthorities == null ?  new ArrayList() : taxAuthorities;
    }

    public void setTaxAuthorities(List<TaxAuthorities> taxAuthorities) {
        this.taxAuthorities = taxAuthorities;
    }

    public List<Message> getMessages() {
        return messages == null ?  new ArrayList():  messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
