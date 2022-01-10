package com.bankSophos.back_bank.service;

import com.bankSophos.back_bank.interfaceService.InterfaceTransactionService;
import com.bankSophos.back_bank.interfaces.InterfaceTransaction;
import com.bankSophos.back_bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements InterfaceTransactionService {

    @Autowired
    private InterfaceTransaction dataTransaction;

    @Override
    public Transaction createTransaction(Transaction transaction, int idPrincipalProduct) {
        return dataTransaction.save(transaction);
    }

    @Override
    public List<Transaction> listIdTransaction(int idPrincipalProduct) {
        return dataTransaction.findByIdPrincipalProductAndResultOperation(idPrincipalProduct, "Efectiva");
    }


}
