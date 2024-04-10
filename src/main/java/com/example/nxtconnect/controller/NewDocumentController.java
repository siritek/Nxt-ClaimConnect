package com.example.nxtconnect.controller;

import java.util.List;

import com.example.nxtconnect.model.NewDocument;
import com.example.nxtconnect.service.NewDocumentServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newdocumentfirst")
//@CrossOrigin
public class NewDocumentController {


    private NewDocumentServiceImpl newdocumentService = new NewDocumentServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody NewDocument newdocument){
        newdocumentService.saveNewDocument(newdocument);
        System.out.println("Connection reached Controller");
        return "New NewDocument info is added";
    }

    @GetMapping("/getAll")
    public List<NewDocument> getAllnewdocuments() {
        return newdocumentService.getAllnewdocuments();
    }
}
