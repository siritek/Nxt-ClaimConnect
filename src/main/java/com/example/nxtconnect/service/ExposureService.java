package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Exposure;

import java.util.List;

public interface ExposureService {

    public void saveExposure(Exposure exposure);

    public List<Exposure> getAllexposures() ;
}
