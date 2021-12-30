package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceClientService;
import com.bankSophos.back_bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clients")
public class controller {

    @Autowired
    InterfaceClientService service;

    @GetMapping("/list")
    public List<Client> list(){
        return service.list();
    }

}
