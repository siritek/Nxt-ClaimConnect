package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Policyinformation;

import java.util.List;


public interface PolicyinformationService {
    public void savePolicyinformation(Policyinformation policyinformation);

    public List<Policyinformation> getAllpolicyinformations();



}
