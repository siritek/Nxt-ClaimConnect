package com.example.nxtconnect.controller;

import com.example.nxtconnect.model.PolicyLevelCoverage;
import com.example.nxtconnect.service.PolicyLevelCoverageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//@CrossOrigin(origins = {"http://localhost:3000", "https://gfnurnjftf.us-east-1.awsapprunner.com"})
@RestController
@RequestMapping("/policyLevelCoverage")
public class PolicyLevelCoverageController {
    private PolicyLevelCoverageServiceImpl policyLevelCoverageService = new PolicyLevelCoverageServiceImpl();

    @PostMapping("/all")
    public String all(@RequestBody PolicyLevelCoverage policyLevelCoverage){
        try{
            policyLevelCoverageService.savePolicyLevelCoverage(policyLevelCoverage);
            String json = new ObjectMapper().writeValueAsString(policyLevelCoverage);
            System.out.println("received this json from react for policyLevelCoverages :- " + json);
            System.out.println("Connection reached Controller");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "";
    }

    @GetMapping("/getAll")
    public List<PolicyLevelCoverage> getAllpolicyLevelCoverages(){
        return policyLevelCoverageService.getAllpolicyLevelCoverages();
    }

}