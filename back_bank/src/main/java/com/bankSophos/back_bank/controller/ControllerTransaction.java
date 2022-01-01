package com.bankSophos.back_bank.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http:localhost:4200")
@RestController
@RequestMapping("/clients/idClient={idClient}/products/idProduct={idProduct}")
public class ControllerTransaction {
}
