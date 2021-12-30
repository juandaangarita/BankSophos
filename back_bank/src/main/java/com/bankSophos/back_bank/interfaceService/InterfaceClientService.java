package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Client;

import java.util.List;
import java.util.Optional;

public interface InterfaceClientService {
    public List<Client> list();
    public Optional<Client> listId(int id);
    public int save(Client p);
    public void delete(int id);
}