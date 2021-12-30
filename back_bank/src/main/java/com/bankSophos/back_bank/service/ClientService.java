package com.bankSophos.back_bank.service;

import com.bankSophos.back_bank.interfaceService.InterfaceClientService;
import com.bankSophos.back_bank.interfaces.InterfaceClient;
import com.bankSophos.back_bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements InterfaceClientService {

    @Autowired
    private InterfaceClient data;

    @Override
    public List<Client> list() {
        return (List<Client>) data.findAll();
    }

    @Override
    public Optional<Client> listId(int id) {
        return Optional.empty();
    }

    @Override
    public Client add(Client c) {
        return data.save(c);
    }

    @Override
    public Client edit(Client c) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
