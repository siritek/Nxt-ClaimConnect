package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Documents;

import java.util.List;

public interface DocumentsService {


    public void saveDocuments(Documents documents);

    public List<Documents> getAlldocuments() ;
}
