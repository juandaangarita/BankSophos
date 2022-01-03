package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Client;

import java.util.List;

public interface InterfaceClientService {
    public List<Client> list();
    public Client listIdOneClient(int id);
    public Client add(Client c);
    public Client edit(Client c);
    public void delete(int id);
}
