package com.example.nxtconnect.controller;

import com.example.nxtconnect.service.GWCCResponseServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.example.nxtconnect.model.GWCCResponse;
import com.google.gson.Gson;
@RestController
@RequestMapping("/GWCCResponse")

public class GWCCResponseController {
    private GWCCResponseServiceImpl GWCCResponseService = new GWCCResponseServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody GWCCResponse gwccresponse) {
        System.out.println("inside add");
        System.out.println("Received JSON: " + new Gson().toJson(gwccresponse));
        System.out.println("GWclaimnumber: " + gwccresponse.getGwClaimnumber());
        System.out.println("BaseClaimNumber: " + gwccresponse.getBaseClaimNumber());
        System.out.println("BasePolicyNumber: " + gwccresponse.getBasePolicyNumber());
        //System.out.println("Response: " + gwccresponse.getResponse());
        //System.out.println("Other: " + gwccresponse.getOther());
        System.out.println("CreatedDate: " + gwccresponse.getCreatedDate());
            System.out.println("Connection reached GWCCResponse Controller");
            GWCCResponseService.saveGWCCResponse(gwccresponse);

        return "New GWCCResponse info is added";
}

}


