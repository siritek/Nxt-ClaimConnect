package com.example.nxtconnect.controller;

import com.example.nxtconnect.model.GwTransaction;
import com.example.nxtconnect.service.DBConn;
import com.example.nxtconnect.service.GwTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:3000", "https://gfnurnjftf.us-east-1.awsapprunner.com"})
@RestController
@RequestMapping("/nxt_gwtransaction")
public class GwTransactionController
{
    private final GwTransactionServiceImpl transactionService;
    private final DBConn dbConn;

    @Autowired
    public GwTransactionController(DBConn dbConn, GwTransactionServiceImpl transactionService) {
        this.dbConn = dbConn;
        this.transactionService = transactionService;
    }


    @GetMapping("/getAll")
    public List<GwTransaction> getAllGwTransactions() {
        return transactionService.getAllGwTransactions();
    }
}