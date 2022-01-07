package com.bankSophos.back_bank.controller;

import com.bankSophos.back_bank.interfaceService.InterfaceProductService;
import com.bankSophos.back_bank.interfaceService.InterfaceTransactionService;
import com.bankSophos.back_bank.model.Product;
import com.bankSophos.back_bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http:localhost:4200")
@RestController
@RequestMapping("/clients/{idClient}/products/{idProduct}/transaction")
public class ControllerTransaction {

    @Autowired
    InterfaceTransactionService serviceTransaction;

    @Autowired
    InterfaceProductService serviceProduct;

    //Create a transaction
    @PostMapping("")
    @ResponseBody
    public Transaction saveTransaction(@RequestBody Transaction transaction, @PathVariable("idClient") int idClient, @PathVariable("idProduct") int idProduct){
        Product product = serviceProduct.listIdOneProduct(idProduct);
        transaction.setIdPrincipalClient(idClient);
        transaction.setIdPrincipalProduct(idProduct);
        if (product.getState().equals("Cancelado")){
            transaction.setResultOperation("Producto cancelado");
        }
        else if(transaction.getTypeOperation().equals("Consignación")){
            transaction.setFinalBalance(product.getBalance()+transaction.getValueOperation());
            transaction.setResultOperation("Effective");
        }
        else if(transaction.getTypeOperation().equals("Retiro") && product.getState().equals("activa")){
            if (product.getTypeAccount().equals("ahorros") && product.getBalance() - transaction.getValueOperation() >= 0){
                transaction.setFinalBalance(product.getBalance() - transaction.getValueOperation());
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setResultOperation("Effective");
            }
            else if (product.getTypeAccount().equals("corriente") && product.getBalance() - transaction.getValueOperation() >= -2000000){
                transaction.setFinalBalance(product.getBalance() - transaction.getValueOperation());
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setResultOperation("Effective");
            }
            else{
                transaction.setResultOperation("Saldo insuficiente");
                transaction.setFinalBalance(product.getBalance());
            }
        }
        else if(transaction.getTypeOperation().equals("Transferencia") && product.getState().equals("activa")){
            Product productReception = serviceProduct.listIdOneProduct(transaction.getIdSecondaryProduct());
            if (product.getTypeAccount().equals("ahorros") && product.getBalance() - transaction.getValueOperation() >= 0) {
                transaction.setIdSecondaryClient(transaction.getIdSecondaryClient());
                transaction.setIdSecondaryProduct(transaction.getIdSecondaryProduct());
                transaction.setFinalBalance(product.getBalance() - transaction.getValueOperation());
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setResultOperation("Effective");
                //Creation of the receiving transaction
                Transaction transactionReception = new Transaction();
                transactionReception.setIdPrincipalClient(transaction.getIdSecondaryClient());
                transactionReception.setIdPrincipalProduct(transaction.getIdSecondaryProduct());
                transactionReception.setValueOperation(-transaction.getValueOperation());
                transactionReception.setFinalBalance(productReception.getBalance() - transaction.getValueOperation());
                transactionReception.setDescription("Recepción transferencia " + transaction.getDescription() + " desde producto: " + transaction.getIdPrincipalClient());
                transactionReception.setResultOperation("Effective");
                transactionReception.setDateOperation(transaction.getDateOperation());
                transactionReception.setTypeOperation("Transferencia");
                transactionReception.setIdSecondaryClient(transaction.getIdPrincipalClient());
                transactionReception.setIdSecondaryProduct(transaction.getIdPrincipalProduct());
                serviceTransaction.createTransaction(transactionReception, transaction.getIdSecondaryClient(), transaction.getIdSecondaryProduct());
                //Updating balance in receiving product
                productReception.setBalance(transactionReception.getFinalBalance());
                serviceProduct.updateBalance(productReception);
            }
            else if (product.getTypeAccount().equals("corriente") && product.getBalance() - transaction.getValueOperation() >= -2000000){
                transaction.setIdSecondaryClient(transaction.getIdSecondaryClient());
                transaction.setIdSecondaryProduct(transaction.getIdSecondaryProduct());
                transaction.setFinalBalance(product.getBalance() - transaction.getValueOperation());
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setResultOperation("Effective");
                //Creation of the receiving transaction
                Transaction transactionReception = new Transaction();
                transactionReception.setIdPrincipalClient(transaction.getIdSecondaryClient());
                transactionReception.setIdPrincipalProduct(transaction.getIdSecondaryProduct());
                transactionReception.setValueOperation(-transaction.getValueOperation());
                transactionReception.setFinalBalance(productReception.getBalance() - transaction.getValueOperation());
                transactionReception.setDescription("Recepción transferencia " + transaction.getDescription() + " desde producto: " + transaction.getIdPrincipalClient());
                transactionReception.setResultOperation("Effective");
                transactionReception.setDateOperation(transaction.getDateOperation());
                transactionReception.setTypeOperation("Transferencia");
                transactionReception.setIdSecondaryClient(transaction.getIdPrincipalClient());
                transactionReception.setIdSecondaryProduct(transaction.getIdPrincipalProduct());
                serviceTransaction.createTransaction(transactionReception, transaction.getIdSecondaryClient(), transaction.getIdSecondaryProduct());
                //Updating balance in receiving product
                productReception.setBalance(transactionReception.getFinalBalance());
                serviceProduct.updateBalance(productReception);
            }
            else{
                transaction.setResultOperation("Saldo insuficiente");
                transaction.setFinalBalance(product.getBalance());
            }
        }
        else {
            transaction.setResultOperation("Cuenta inactiva");
            transaction.setFinalBalance(product.getBalance());
        }
        product.setBalance(transaction.getFinalBalance());
        serviceProduct.updateBalance(product);


        return serviceTransaction.createTransaction(transaction, idClient, idProduct);
    }

    //Get transaction effective by product, by client
    @GetMapping("")
    public List<Transaction> listIdTransaction(@PathVariable("idClient") int idPrincipalClient, @PathVariable("idProduct") int idPrincipalProduct, String resultOperation){
        return serviceTransaction.listIdTransaction(idPrincipalClient, idPrincipalProduct, "Effective");
    }


}
