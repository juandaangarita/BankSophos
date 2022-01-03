package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceClientService;
import com.bankSophos.back_bank.model.Client;
import com.bankSophos.back_bank.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients")
public class ControllerClient {

    @Autowired
    InterfaceClientService service;

    //Listing all the clients
    @GetMapping("")
    public List<Client> list(){
        return service.list();
    }

    //Create a new client
    @PostMapping("")
    @ResponseBody
    public Client save(@RequestBody Client c){
        return service.add(c);
    }

    //List just one client by its Id
    @GetMapping("/{id}")
    public Client listIdOneClient(@PathVariable("id") int id){
        return service.listIdOneClient(id);
    }

    //Edit client info of the id selected
    @PutMapping("/{id}")
    public Client edit(@RequestBody Client c, @PathVariable("id") int id){
        c.setId(id);
        return service.edit(c);
    }

    //Delete a client info
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }


}
