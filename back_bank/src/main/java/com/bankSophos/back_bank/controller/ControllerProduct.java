package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceProductService;
import com.bankSophos.back_bank.interfaceService.InterfaceTransactionService;
import com.bankSophos.back_bank.model.Product;
import com.bankSophos.back_bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients/{idClient}/products")
public class ControllerProduct {

    @Autowired
    InterfaceProductService serviceProduct;

    @Autowired
    InterfaceTransactionService transactionService;

    //List products owned by the client
    @GetMapping("")
    public List<Product> listIdProduct(@PathVariable("idClient") int idClient){
        return serviceProduct.listIdProduct(idClient);
    }

    //List of products different to the selected one
    @GetMapping("/{idProduct}/different")
    public List<Product> listIdOtherAvailableProducts(@PathVariable("idClient") int idClient, @PathVariable("idProduct") int idProduct){
        return serviceProduct.listIdOtherAvailableProducts(idClient,idProduct);
    }


    //Create a new product for a cliente
    @PostMapping("")
    @ResponseBody
    public Product save(@RequestBody Product product, @PathVariable("idClient") int idClient, Transaction transaction){
        product.setIdClient(idClient);
        transaction.setIdPrincipalProduct(product.getIdProduct());
        transaction.setIdPrincipalClient(product.getIdClient());
        transaction.setDescription("Creación producto");
        transaction.setResultOperation("Effective");
        transaction.setFinalBalance(0);
        transaction.setValueOperation(0);
        transactionService.createTransaction(transaction, idClient, product.getIdProduct());
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

    //Change status to cancell product
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

    //Update product balance
    @PutMapping("/{idProduct}")
    public Product updateBalance(Product product, @PathVariable("idProduct") int idProduct, int finalBalance){
        product = ListIdOneProduct(idProduct);
        product.setBalance(finalBalance);
        return serviceProduct.updateBalance(product);
    }

    //Add money
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

    //Withdraw money
    @PutMapping("/{idProduct}/{money}/withdraw")
    public Product withdrawMovement(Product product, @PathVariable("idProduct") int idProduct, @PathVariable("money") int money){
        product = ListIdOneProduct(idProduct);
        product.setIdProduct(idProduct);
        product.setIdClient(product.getIdClient());
        product.setTypeAccount(product.getTypeAccount());
        product.setNumberAccount(product.getNumberAccount());
        product.setCreationDate(product.getCreationDate());
        product.setState(product.getState());
        if (money > product.getBalance())
        {
            product.setBalance(0);
        }
        else{
            product.setBalance(product.getBalance() - money);
        }
        return serviceProduct.changeStatus(product);
    }



}
