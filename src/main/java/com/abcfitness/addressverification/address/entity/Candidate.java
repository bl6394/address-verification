package com.abcfitness.addressverification.address.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "smartys_candidate")
public class Candidate{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String inputId;
    private int inputIndex;
    private int candidateIndex;
    private String addressee;
    @Column(name = "delivery_line_1")
    private String deliveryLine1;
    @Column(name = "delivery_line_2")
    private String deliveryLine2;
    private String lastLine;
    private String deliveryPointBarcode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "components_id", referencedColumnName = "id")
    private Components components;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    private Metadata metadata;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "analysis_id", referencedColumnName = "id")
    private Analysis analysis;

    @ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    private Address address;


    public Candidate() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public int getInputIndex() {
        return inputIndex;
    }

    public void setInputIndex(int inputIndex) {
        this.inputIndex = inputIndex;
    }

    public int getCandidateIndex() {
        return candidateIndex;
    }

    public void setCandidateIndex(int candidateIndex) {
        this.candidateIndex = candidateIndex;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getDeliveryLine1() {
        return deliveryLine1;
    }

    public void setDeliveryLine1(String deliveryLine1) {
        this.deliveryLine1 = deliveryLine1;
    }

    public String getDeliveryLine2() {
        return deliveryLine2;
    }

    public void setDeliveryLine2(String deliveryLine2) {
        this.deliveryLine2 = deliveryLine2;
    }

    public String getLastLine() {
        return lastLine;
    }

    public void setLastLine(String lastLine) {
        this.lastLine = lastLine;
    }

    public String getDeliveryPointBarcode() {
        return deliveryPointBarcode;
    }

    public void setDeliveryPointBarcode(String deliveryPointBarcode) {
        this.deliveryPointBarcode = deliveryPointBarcode;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
