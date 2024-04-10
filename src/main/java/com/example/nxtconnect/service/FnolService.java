package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Fnol;

import java.util.List;

public interface FnolService {


    public void saveFnol(Fnol fnol);

    public List<Fnol> getAllfnols();
}
