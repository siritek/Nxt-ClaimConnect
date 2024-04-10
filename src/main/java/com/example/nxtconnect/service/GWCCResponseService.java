package com.example.nxtconnect.service;

import com.example.nxtconnect.model.GWCCResponse;

import java.util.List;

public interface GWCCResponseService {
    public boolean saveGWCCResponse(GWCCResponse gwccResponse);

    public List<GWCCResponse> getAllGWCCresponses() ;


}



