package com.example.nxtconnect.service;

import com.example.nxtconnect.model.NewDocument;

import java.util.List;

public interface NewDocumentService {


    public void saveNewDocument(NewDocument newdocument);

    public List<NewDocument> getAllnewdocuments() ;
}
