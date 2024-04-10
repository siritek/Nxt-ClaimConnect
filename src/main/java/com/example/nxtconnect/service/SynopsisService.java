package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Synopsis;

import java.util.List;

public interface SynopsisService {
    public void saveSynopsis(Synopsis synopsis);

    public List<Synopsis> getAllsynopsis();
}
