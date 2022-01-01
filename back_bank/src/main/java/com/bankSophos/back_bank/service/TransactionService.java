package com.bankSophos.back_bank.service;

import com.bankSophos.back_bank.interfaceService.InterfaceTransactionService;
import com.bankSophos.back_bank.model.Transaction;

public class TransactionService implements InterfaceTransactionService {
    @Override
    public Transaction createTransaction(Transaction transaction, int idPrincipalClient, int idPrincipalProduct) {
        return null;
    }
}
