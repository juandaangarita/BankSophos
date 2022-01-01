package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Transaction;

public interface InterfaceTransactionService {
    public Transaction createTransaction(Transaction transaction, int idPrincipalClient, int idPrincipalProduct);

}
