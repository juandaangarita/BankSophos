package com.bankSophos.back_bank.interfaces;

import com.bankSophos.back_bank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceClient extends JpaRepository<Client, Integer> {

    Client findById(int id);

}
