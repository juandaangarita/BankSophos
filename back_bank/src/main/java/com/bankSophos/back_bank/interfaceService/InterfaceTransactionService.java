package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Transaction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterfaceTransactionService {
    public Transaction createTransaction(Transaction transaction, int idPrincipalClient, int idPrincipalProduct);

    //@Query(value="SELECT * FROM transaction t WHERE t.id_principal_client=?1 AND t.id_principal_product=?2 AND t.result_operation=?3")
    public List<Transaction> listIdTransaction(int idPrincipalClient, int idPrincipalProduct, String resultOperation);
}
