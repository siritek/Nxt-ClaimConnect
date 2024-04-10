package com.example.nxtconnect.controller;

import com.example.nxtconnect.DAO.LossLocationDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/losslocationsDD")
//losslocation Drop down values
public class LossLocationDAOController {
    private final LossLocationDAO lossLocationDAO ;

    public LossLocationDAOController(LossLocationDAO lossLocationDAO) {
        this.lossLocationDAO = lossLocationDAO; ;
    }
    @GetMapping
    public Map<String, List<String>> getLossLocationDD () {
        System.out.println("Connection reached lossLocationDAOController getLosslocations method\n");
        return lossLocationDAO.getLossLocationDD();
    }



}
