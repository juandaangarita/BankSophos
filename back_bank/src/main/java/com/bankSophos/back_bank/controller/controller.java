package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceClientService;
import com.bankSophos.back_bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients")
public class controller {

    @Autowired
    InterfaceClientService service;

    @GetMapping("/list")
    public List<Client> list(){
        return service.list();
    }

    @PostMapping("/add")
    @ResponseBody
    public Client save(@RequestBody Client c){
        return service.add(c);
    }

    @GetMapping(path={"/{id}"})
    public Optional<Client> listId(@PathVariable("id") int id){
        return service.listId(id);
    }

    @PutMapping(path={"/{id}"})
    public Client edit(@RequestBody Client c, @PathVariable("id") int id){
        c.setId(id);
        return service.edit(c);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }


}
