package com.example.nxtconnect.service;

import com.example.nxtconnect.model.PolicyLevelCoverage;

import java.util.List;

public interface PolicyLevelCoverageService
{
    public void savePolicyLevelCoverage(PolicyLevelCoverage policyLevelCoverage);

    public List<PolicyLevelCoverage> getAllpolicyLevelCoverages();


}
