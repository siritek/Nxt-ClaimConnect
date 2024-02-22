package com.example.withoutdb.model;

public class CCClaimPayload {


    private String PolicyNumber;
    private String ClaimNumber;
    private String LossDate;
    private String ReportedDate;
    private String Address;
    private String LossDescription;
    private String LossLocation;
    private String Name;
    private String TimeOfLoss;

    private String PolicyType;

    private String BaseClaimNumber;
    private String TypeOfLoss;
    private String WeatherInvolved;
    private String WeatherDescription;
    private String RelationshipToInsured;
    private String Country;
    private String City;
    private String Zipcode;
    private String State;
    private String ReportedBy;

    private String LossParty;

    private String CreationDate;
    private String Claimant;
    private String ClaimantType;

    private String BasePolicyNumber;
    private String HowReported;

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getClaimNumber() {
        return ClaimNumber;
    }

    public String getReportedBy() {
        return ReportedBy;
    }

    public void setReportedBy(String reportedBy) {
        ReportedBy = reportedBy;
    }

    public void setClaimNumber(String claimNumber) {
        ClaimNumber = claimNumber;
    }

    public String getLossDate() {
        return LossDate;
    }

    public void setLossDate(String lossDate) {
        LossDate = lossDate;
    }

    public String getReportedDate() {
        return ReportedDate;
    }

    public void setReportedDate(String reportedDate) {
        ReportedDate = reportedDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLossDescription() {
        return LossDescription;
    }

    public void setLossDescription(String lossDescription) {
        LossDescription = lossDescription;
    }

    public String getLossLocation() {
        return LossLocation;
    }

    public void setLossLocation(String lossLocation) {
        LossLocation = lossLocation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTimeOfLoss() {
        return TimeOfLoss;
    }

    public void setTimeOfLoss(String timeOfLoss) {
        TimeOfLoss = timeOfLoss;
    }

    public String getPolicyType() {
        return PolicyType;
    }

    public void setPolicyType(String policyType) {
        PolicyType = policyType;
    }

    public String getBaseClaimNumber() {
        return BaseClaimNumber;
    }

    public void setBaseClaimNumber(String baseClaimNumber) {
        BaseClaimNumber = baseClaimNumber;
    }

    public String getTypeOfLoss() {
        return TypeOfLoss;
    }

    public void setTypeOfLoss(String typeOfLoss) {
        TypeOfLoss = typeOfLoss;
    }

    public String getWeatherInvolved() {
        return WeatherInvolved;
    }

    public void setWeatherInvolved(String weatherInvolved) {
        WeatherInvolved = weatherInvolved;
    }

    public String getWeatherDescription() {
        return WeatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        WeatherDescription = weatherDescription;
    }

    public String getRelationshipToInsured() {
        return RelationshipToInsured;
    }

    public void setRelationshipToInsured(String relationshipToInsured) {
        RelationshipToInsured = relationshipToInsured;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getLossParty() {
        return LossParty;
    }

    public void setLossParty(String lossParty) {
        LossParty = lossParty;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getClaimant() {
        return Claimant;
    }

    public void setClaimant(String claimant) {
        Claimant = claimant;
    }

    public String getClaimantType() {
        return ClaimantType;
    }

    public void setClaimantType(String claimantType) {
        ClaimantType = claimantType;
    }

    public String getBasePolicyNumber() {
        return BasePolicyNumber;
    }

    public void setBasePolicyNumber(String basePolicyNumber) {
        BasePolicyNumber = basePolicyNumber;
    }

    public String getHowReported() {
        return HowReported;
    }

    public void setHowReported(String howReported) {
        HowReported = howReported;
    }
}

//package com.example.withoutdb.model;


//
//public class CCClaimPayload {
//
//
//    private String policyNumber;
//    private String claimNumber;
//    private String dateOfLoss;
//    private String dateOfReport;
//    private String address1;
//    private String lossDescription;
//    private String lossLocation;
//    private String name;
//    private String TimeofLoss;
//    private String policyVerified;
//    private String policyStatus;
//    private String policyType;
//    private String address;
//    private String lossCause;
//    private String BaseClaimNumber;
//    private String typeOfLoss;
//    private String weatherInvolved;
//    private String weatherDescription;
//    private String relationshipToInsured;
//    private String countries;
//    private String city;
//    private String zipcode;
//    private String state;
//    private String jurisdiction;
//    private String lossParty;
//    private String primaryCoverage;
//    private String exposuresStatus;
//    private String creationDate;
//    private String claimant;
//    private String claimantType;
//    private String exposureType;
//    private String exposureDescription;
//
//    private String BasePolicyNumber;
//private String HowReported;
//
//    public String getHowReported() {
//        return HowReported;
//    }
//
//    public void setHowReported(String howReported) {
//        HowReported = howReported;
//    }
//
//    public String getBasePolicyNumber() {
//        return BasePolicyNumber;
//    }
//
//    public void setBasePolicyNumber(String basePolicyNumber) {
//        BasePolicyNumber = basePolicyNumber;
//    }
//
//    public String getPolicyNumber() {
//        return policyNumber;
//    }
//
//    public void setPolicyNumber(String policyNumber) {
//        this.policyNumber = policyNumber;
//    }
//
//    public String getBaseClaimNumber() {
//        return BaseClaimNumber;
//    }
//
//    public void setBaseClaimNumber(String baseClaimNumber) {
//        BaseClaimNumber = baseClaimNumber;
//    }
//
//    public String getClaimNumber() {
//        return claimNumber;
//    }
//
//    public void setClaimNumber(String claimNumber) {
//        this.claimNumber = claimNumber;
//    }
//
//    public String getDateOfLoss() {
//        return dateOfLoss;
//    }
//
//    public void setDateOfLoss(String dateOfLoss) {
//        this.dateOfLoss = dateOfLoss;
//    }
//
//    public String getDateOfReport() {
//        return dateOfReport;
//    }
//
//    public void setDateOfReport(String dateOfReport) {
//        this.dateOfReport = dateOfReport;
//    }
//
//    public String getAddress1() {
//        return address1;
//    }
//
//    public void setAddress1(String address1) {
//        this.address1 = address1;
//    }
//
//    public String getLossDescription() {
//        return lossDescription;
//    }
//
//    public void setLossDescription(String lossDescription) {
//        this.lossDescription = lossDescription;
//    }
//
//    public String getLossLocation() {
//        return lossLocation;
//    }
//
//    public void setLossLocation(String lossLocation) {
//        this.lossLocation = lossLocation;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTimeofLoss() {
//        return TimeofLoss;
//    }
//
//    public void setTimeofLoss(String timeofLoss) {
//        TimeofLoss = timeofLoss;
//    }
//
//    public String getPolicyVerified() {
//        return policyVerified;
//    }
//
//    public void setPolicyVerified(String policyVerified) {
//        this.policyVerified = policyVerified;
//    }
//
//
//    public String getPolicyStatus() {
//        return policyStatus;
//    }
//
//    public void setPolicyStatus(String policyStatus) {
//        this.policyStatus = policyStatus;
//    }
//
//    public String getPolicyType() {
//        return policyType;
//    }
//
//    public void setPolicyType(String policyType) {
//        this.policyType = policyType;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getLossCause() {
//        return lossCause;
//    }
//
//    public void setLossCause(String lossCause) {
//        this.lossCause = lossCause;
//    }
//
//
//    public String getTypeOfLoss() {
//        return typeOfLoss;
//    }
//
//    public void setTypeOfLoss(String typeOfLoss) {
//        this.typeOfLoss = typeOfLoss;
//    }
//
//    public String getWeatherInvolved() {
//        return weatherInvolved;
//    }
//
//    public void setWeatherInvolved(String weatherInvolved) {
//        this.weatherInvolved = weatherInvolved;
//    }
//
//    public String getWeatherDescription() {
//        return weatherDescription;
//    }
//
//    public void setWeatherDescription(String weatherDescription) {
//        this.weatherDescription = weatherDescription;
//    }
//
//    public String getRelationshipToInsured() {
//        return relationshipToInsured;
//    }
//
//    public void setRelationshipToInsured(String relationshipToInsured) {
//        this.relationshipToInsured = relationshipToInsured;
//    }
//
//
//
//    public String getCountries() {
//        return countries;
//    }
//
//    public String setCountries(String countries) {
//        this.countries = countries;
//        return countries;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getJurisdiction() {
//        return jurisdiction;
//    }
//
//    public void setJurisdiction(String jurisdiction) {
//        this.jurisdiction = jurisdiction;
//    }
//
//    public String getLossParty() {
//        return lossParty;
//    }
//
//    public void setLossParty(String lossParty) {
//        this.lossParty = lossParty;
//    }
//
//    public String getPrimaryCoverage() {
//        return primaryCoverage;
//    }
//
//    public void setPrimaryCoverage(String primaryCoverage) {
//        this.primaryCoverage = primaryCoverage;
//    }
//
//    public String getExposuresStatus() {
//        return exposuresStatus;
//    }
//
//    public void setExposuresStatus(String exposuresStatus) {
//        this.exposuresStatus = exposuresStatus;
//    }
//
//    public String getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(String creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public String getClaimant() {
//        return claimant;
//    }
//
//    public void setClaimant(String claimant) {
//        this.claimant = claimant;
//    }
//
//    public String getClaimantType() {
//        return claimantType;
//    }
//
//    public void setClaimantType(String claimantType) {
//        this.claimantType = claimantType;
//    }
//
//
//    public String getExposureType() {
//        return exposureType;
//    }
//
//    public void setExposureType(String exposureType) {
//        this.exposureType = exposureType;
//    }
//
//    public String getExposureDescription() {
//        return exposureDescription;
//    }
//
//    public void setExposureDescription(String exposureDescription) {
//        this.exposureDescription = exposureDescription;
//    }
//
//
//}
