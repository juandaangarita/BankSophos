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
    public Transaction saveTransaction(@RequestBody Transaction transaction, @PathVariable("idProduct") int idProduct){
        Product product = serviceProduct.listIdOneProduct(idProduct);
        transaction.setIdPrincipalProduct(idProduct);
        if (product.getState().equals("Cancelado")){
            transaction.setResultOperation("Producto cancelado");
        }
        else if(transaction.getTypeOperation().equals("Consignación")){
            transaction.setFinalBalance(product.getBalance()+transaction.getValueOperation());
            transaction.setResultOperation("Efectiva");
            transaction.setFinanceMovement("Crédito");
        }
        else if(transaction.getTypeOperation().equals("Retiro") && product.getState().equals("activa")){
            if (product.getTypeAccount().equals("ahorros") && product.getBalance() - (1.004 * transaction.getValueOperation()) >= 0){
                //Creation of the GMF transaction
                Transaction transactionGMF = new Transaction();
                transactionGMF.setIdPrincipalProduct(idProduct);
                transactionGMF.setValueOperation(-0.004 * transaction.getValueOperation());
                transactionGMF.setFinalBalance(product.getBalance() - 0.004 * transaction.getValueOperation());
                transactionGMF.setDescription("GMF 4 x 1000");
                transactionGMF.setResultOperation("Efectiva");
                transactionGMF.setDateOperation(transaction.getDateOperation());
                transactionGMF.setTypeOperation("GMF");
                transactionGMF.setFinanceMovement("Débito");
                serviceTransaction.createTransaction(transactionGMF, idProduct);
                //Updating the transaction
                transaction.setFinalBalance(product.getBalance() - (1.004 * transaction.getValueOperation()));
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setIdSecondaryProduct(0);
                transaction.setResultOperation("Efectiva");
                transaction.setFinanceMovement("Débito");
                transaction.setGMF(-0.004 * transaction.getValueOperation());
            }
            else if (product.getTypeAccount().equals("corriente") && product.getBalance() - (1.004 * transaction.getValueOperation()) >= -2000000){
                //Creation of the GMF transaction
                Transaction transactionGMF = new Transaction();
                transactionGMF.setIdPrincipalProduct(idProduct);
                transactionGMF.setValueOperation(-0.004 * transaction.getValueOperation());
                transactionGMF.setFinalBalance(product.getBalance() - 0.004 * transaction.getValueOperation());
                transactionGMF.setDescription("GMF 4 x 1000");
                transactionGMF.setResultOperation("Efectiva");
                transactionGMF.setDateOperation(transaction.getDateOperation());
                transactionGMF.setTypeOperation("GMF");
                transactionGMF.setFinanceMovement("Débito");
                serviceTransaction.createTransaction(transactionGMF, idProduct);
                //Updating the transaction
                transaction.setFinalBalance(product.getBalance() - (1.004 * transaction.getValueOperation()));
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setIdSecondaryProduct(0);
                transaction.setResultOperation("Efectiva");
                transaction.setFinanceMovement("Débito");
                transaction.setGMF(-0.004 * transaction.getValueOperation());
            }
            else{
                transaction.setResultOperation("Saldo insuficiente. Saldo disponible para retiro es: " + 0.996 * product.getBalance());
                transaction.setFinalBalance(product.getBalance());
            }
        }
        else if(transaction.getTypeOperation().equals("Transferencia") && product.getState().equals("activa")){
            Product productReception = serviceProduct.listIdOneProduct(transaction.getIdSecondaryProduct());
            if (product.getTypeAccount().equals("ahorros") && product.getBalance() - (1.004 * transaction.getValueOperation()) >= 0) {
                transaction.setIdSecondaryProduct(transaction.getIdSecondaryProduct());
                //Creation of the GMF transaction
                Transaction transactionGMF = new Transaction();
                transactionGMF.setIdPrincipalProduct(idProduct);
                transactionGMF.setValueOperation(-0.004 * transaction.getValueOperation());
                transactionGMF.setFinalBalance(product.getBalance() - 0.004 * transaction.getValueOperation());
                transactionGMF.setDescription("GMF 4 x 1000");
                transactionGMF.setResultOperation("Efectiva");
                transactionGMF.setDateOperation(transaction.getDateOperation());
                transactionGMF.setTypeOperation("GMF");
                transactionGMF.setFinanceMovement("Débito");
                serviceTransaction.createTransaction(transactionGMF, idProduct);
                //Updating the transaction
                transaction.setFinalBalance(product.getBalance() - (1.004 * transaction.getValueOperation()));
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setResultOperation("Efectiva");
                transaction.setFinanceMovement("Débito");
                transaction.setGMF(-0.004 * transaction.getValueOperation());
                //Creation of the Receiving transaction
                Transaction transactionReception = new Transaction();
                transactionReception.setIdPrincipalProduct(transaction.getIdSecondaryProduct());
                transactionReception.setValueOperation(-transaction.getValueOperation());
                transactionReception.setFinalBalance(productReception.getBalance() - transaction.getValueOperation());
                transactionReception.setDescription("Recepción transferencia " + transaction.getDescription() + " desde producto: " + transaction.getIdPrincipalProduct());
                transactionReception.setResultOperation("Efectiva");
                transactionReception.setDateOperation(transaction.getDateOperation());
                transactionReception.setTypeOperation("Recepción por transferencia");
                transactionReception.setIdSecondaryProduct(transaction.getIdPrincipalProduct());
                transactionReception.setFinanceMovement("Crédito");
                serviceTransaction.createTransaction(transactionReception, transaction.getIdSecondaryProduct());
                //Updating balance in receiving product
                productReception.setBalance(transactionReception.getFinalBalance());
                serviceProduct.updateBalance(productReception);
            }
            else if (product.getTypeAccount().equals("corriente") && product.getBalance() - (1.004 * transaction.getValueOperation()) >= -2000000){
                transaction.setIdSecondaryProduct(transaction.getIdSecondaryProduct());

                //Creation of the GMF transaction
                Transaction transactionGMF = new Transaction();
                transactionGMF.setIdPrincipalProduct(idProduct);
                transactionGMF.setValueOperation(-0.004 * transaction.getValueOperation());
                transactionGMF.setFinalBalance(product.getBalance() - 0.004 * transaction.getValueOperation());
                transactionGMF.setDescription("GMF 4 x 1000");
                transactionGMF.setResultOperation("Efectiva");
                transactionGMF.setDateOperation(transaction.getDateOperation());
                transactionGMF.setTypeOperation("GMF");
                transactionGMF.setFinanceMovement("Débito");
                serviceTransaction.createTransaction(transactionGMF, idProduct);
                //Updating the transaction
                transaction.setFinalBalance(product.getBalance() - (1.004 * transaction.getValueOperation()));
                transaction.setValueOperation(-transaction.getValueOperation());
                transaction.setResultOperation("Efectiva");
                transaction.setFinanceMovement("Débito");
                transaction.setGMF(-0.004 * transaction.getValueOperation());
                //Creation of the Receiving transaction
                Transaction transactionReception = new Transaction();
                transactionReception.setIdPrincipalProduct(transaction.getIdSecondaryProduct());
                transactionReception.setValueOperation(-transaction.getValueOperation());
                transactionReception.setFinalBalance(productReception.getBalance() - transaction.getValueOperation());
                transactionReception.setDescription("Recepción transferencia " + transaction.getDescription() + " desde producto: " + transaction.getIdPrincipalProduct());
                transactionReception.setResultOperation("Efectiva");
                transactionReception.setDateOperation(transaction.getDateOperation());
                transactionReception.setTypeOperation("Recepción por transferencia");
                transactionReception.setIdSecondaryProduct(transaction.getIdPrincipalProduct());
                transactionReception.setFinanceMovement("Crédito");
                serviceTransaction.createTransaction(transactionReception, transaction.getIdSecondaryProduct());
                //Updating balance in receiving product
                productReception.setBalance(transactionReception.getFinalBalance());
                serviceProduct.updateBalance(productReception);
            }
            else{
                transaction.setResultOperation("Saldo insuficiente. Saldo disponible para transferencia es: " + 0.996 * product.getBalance());
                transaction.setFinalBalance(product.getBalance());
            }
        }
        else {
            transaction.setResultOperation("Cuenta inactiva");
            transaction.setFinalBalance(product.getBalance());
        }
        product.setBalance(transaction.getFinalBalance());
        serviceProduct.updateBalance(product);


        return serviceTransaction.createTransaction(transaction, idProduct);
    }

    //Get transaction effective by product, by client
    @GetMapping("")
    public List<Transaction> listIdTransaction(@PathVariable("idProduct") int idPrincipalProduct){
        return serviceTransaction.listIdTransaction(idPrincipalProduct);
    }


}
