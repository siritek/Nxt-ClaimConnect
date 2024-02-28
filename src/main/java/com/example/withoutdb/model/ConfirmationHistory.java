package com.example.withoutdb.model;

public class ConfirmationHistory {
    private String response;
    private String baseClaimNumber;
    private String basePolicyNumber;
    private String gwClaimnumber;
    private String other;
    private String createdDate;
    private String createDateTime;
    private String gwclaimNumber;
    private String status;

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    // Getter for createDateTime
    public String getCreateDateTime() {
        return createDateTime;
    }

    // Setter for gwclaimNumber
    public void setGwclaimNumber(String gwclaimNumber) {
        this.gwclaimNumber = gwclaimNumber;
    }

    // Getter for gwclaimNumber
    public String getGwclaimNumber() {
        return gwclaimNumber;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getBaseClaimNumber() {
        return baseClaimNumber;
    }

    public void setBaseClaimNumber(String baseClaimNumber) {
        this.baseClaimNumber = baseClaimNumber;
    }

    public String getBasePolicyNumber() {
        return basePolicyNumber;
    }

    public void setBasePolicyNumber(String basePolicyNumber) {
        this.basePolicyNumber = basePolicyNumber;
    }

    public String getGwClaimnumber() {
        return gwClaimnumber;
    }

    public void setGwClaimnumber(String gwClaimnumber) {
        this.gwClaimnumber = gwClaimnumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
