package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Transaction;

import java.util.List;

public interface InterfaceTransactionService {
    public Transaction createTransaction(Transaction transaction, int idPrincipalClient, int idPrincipalProduct);

    public List<Transaction> listIdTransaction(int idPrincipalClient, int idPrincipalProduct);
}
