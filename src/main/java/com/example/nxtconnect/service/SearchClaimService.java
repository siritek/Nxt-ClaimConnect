package com.example.nxtconnect.service;

import com.example.nxtconnect.model.SearchClaim;

import java.util.List;

public interface SearchClaimService {

    public void saveSearchClaim(SearchClaim searchclaim);

    public List<SearchClaim> getAllsearchclaims() ;


}
