package com.bankSophos.back_bank.interfaces;

import com.bankSophos.back_bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceTransaction extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByIdPrincipalClientAndIdPrincipalProductAndResultOperation(int idPrincipalClient, int idPrincipalProduct, String resultOperation);

}
