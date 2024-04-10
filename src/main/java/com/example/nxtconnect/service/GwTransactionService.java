package com.example.nxtconnect.service;


import com.example.nxtconnect.model.GwTransaction;

import java.util.List;

public interface GwTransactionService
{
    public void saveGwTransaction(GwTransaction gwTransaction);

    public List<GwTransaction> getAllGwTransactions();
}
