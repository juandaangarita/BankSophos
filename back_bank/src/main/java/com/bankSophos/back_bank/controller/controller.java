package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceClientService;
import com.bankSophos.back_bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
