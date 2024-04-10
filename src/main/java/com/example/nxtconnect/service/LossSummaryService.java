package com.example.nxtconnect.service;

import com.example.nxtconnect.model.LossSummary;

import java.util.List;

public interface LossSummaryService {
    public void saveLossSummary(LossSummary losssummary);

    public List<LossSummary> getAlllosssummarys() ;

}
