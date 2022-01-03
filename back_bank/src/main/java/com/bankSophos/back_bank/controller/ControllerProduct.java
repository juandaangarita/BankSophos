package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceProductService;
import com.bankSophos.back_bank.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients/{idClient}/products")
public class ControllerProduct {

    @Autowired
    InterfaceProductService serviceProduct;

    //List products owned by the client
    @GetMapping("")
    public List<Product> listIdProduct(@PathVariable("idClient") int idClient){
        return serviceProduct.listIdProduct(idClient);
    }

    //Create a new product for a cliente
    @PostMapping("")
    @ResponseBody
    public Product save(@RequestBody Product product, @PathVariable("idClient") int idClient){
        product.setIdClient(idClient);
        return serviceProduct.addProduct(product, idClient);
    }

    //Get one product of a client
    @GetMapping("/{idProduct}")
    public Product ListIdOneProduct(@PathVariable("idProduct") int idProduct){
        return serviceProduct.listIdOneProduct(idProduct);
    }

    //Change status to active or inactive
    @PutMapping("/{idProduct}/changeStatus")
    public Product changeStatus(Product product, @PathVariable("idProduct") int idProduct){
        product = ListIdOneProduct(idProduct);
        product.setIdProduct(idProduct);
        product.setIdClient(product.getIdClient());
        product.setTypeAccount(product.getTypeAccount());
        product.setNumberAccount(product.getNumberAccount());
        product.setCreationDate(product.getCreationDate());
        product.setBalance(product.getBalance());
        if (product.getState().equals("activa"))
        {
            product.setState("inactiva");
        }
        else if (product.getState().equals("inactiva"))
        {
            product.setState("activa");
        }
        else if (product.getState().equals("Cancelado"))
        {
            product.setState("Cancelado");
        }
        return serviceProduct.changeStatus(product);
    }

    //Change status to active or inactive
    @PutMapping("/{idProduct}/cancel")
    public Product cancelProduct(Product product, @PathVariable("idProduct") int idProduct){
        product = ListIdOneProduct(idProduct);
        product.setIdProduct(idProduct);
        product.setIdClient(product.getIdClient());
        product.setTypeAccount(product.getTypeAccount());
        product.setNumberAccount(product.getNumberAccount());
        product.setCreationDate(product.getCreationDate());
        product.setBalance(product.getBalance());
        if (product.getBalance()!=0)
        {
            product.setState(product.getState());
        }
        else{
            product.setState("Cancelado");
        }
        return serviceProduct.changeStatus(product);
    }

    //Change status to active or inactive
    @PutMapping("/{idProduct}/{money}")
    public Product addMovement(Product product, @PathVariable("idProduct") int idProduct, @PathVariable("money") int money){
        product = ListIdOneProduct(idProduct);
        product.setIdProduct(idProduct);
        product.setIdClient(product.getIdClient());
        product.setTypeAccount(product.getTypeAccount());
        product.setNumberAccount(product.getNumberAccount());
        product.setCreationDate(product.getCreationDate());
        product.setState(product.getState());
        if (product.getBalance()>=0)
        {
            product.setBalance(product.getBalance() + money);
        }
        return serviceProduct.changeStatus(product);
    }



}
