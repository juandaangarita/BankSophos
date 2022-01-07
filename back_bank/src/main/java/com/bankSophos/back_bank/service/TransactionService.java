package com.bankSophos.back_bank.service;

import com.bankSophos.back_bank.interfaceService.InterfaceTransactionService;
import com.bankSophos.back_bank.interfaces.InterfaceTransaction;
import com.bankSophos.back_bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements InterfaceTransactionService {

    @Autowired
    private InterfaceTransaction dataTransaction;

    @Override
    public Transaction createTransaction(Transaction transaction, int idPrincipalClient, int idPrincipalProduct) {
        return dataTransaction.save(transaction);
    }

    //@Query("SELECT * FROM transaction t WHERE t.id_principal_client=?1 AND t.id_principal_product=?2 AND t.result_operation=?3")
    @Override
    public List<Transaction> listIdTransaction(int idPrincipalClient, int idPrincipalProduct, String resultOperation) {
        return dataTransaction.findByIdPrincipalClientAndIdPrincipalProductAndResultOperation(idPrincipalClient, idPrincipalProduct, "Effective");
    }


}
