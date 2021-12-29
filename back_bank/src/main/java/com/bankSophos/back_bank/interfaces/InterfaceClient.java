package com.bankSophos.back_bank.interfaces;

import com.bankSophos.back_bank.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceClient extends CrudRepository<Client, Integer> {
}
