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
    @PostMapping("/addProduct")
    @ResponseBody
    public Product save(@RequestBody Product product, @PathVariable("idClient") int idClient){
        product.setIdClient(idClient);
        return serviceProduct.addProduct(product, idClient);
    }

    //Get one product of a client
    @GetMapping("/{idProduct}")
    public Optional<Product> ListIdOneProduct(@PathVariable("idClient")int idClient, @PathVariable("idProduct") int idProduct){
        return serviceProduct.listIdOneProduct(idClient, idProduct);
    }

    //Change status to active or inactive
    @PutMapping("/{idProduct}/changeStatus")
    public Product changeStatus(Product product, @PathVariable("idProduct") int idProduct, @PathVariable("idClient") int idClient){
        product.setIdProduct(idProduct);
        product.setIdClient(product.getIdClient());
        product.setTypeAccount(product.getTypeAccount());
        product.setNumberAccount(product.getNumberAccount());
        product.setCreationDate(product.getCreationDate());
        product.setBalance(product.getBalance());
        if(product.getState().equals("inactiva")){
            product.setState("activa");
        }
        else {
            product.setState("inactiva");
        }
        return serviceProduct.changeStatus(product, idClient);
    }

    //Get one product of a client
    @GetMapping("/{idProduct}/cancel")
    public Optional<Product> ListIdOneProduct2(@PathVariable("idClient")int idClient, @PathVariable("idProduct") int idProduct){
        return serviceProduct.listIdOneProduct(idClient, idProduct);
    }

    //Change status to cancel
    @PutMapping("/{idProduct}/cancel")
    public Product cancelProduct(Product product, @PathVariable("idProduct") int idProduct, @PathVariable("idClient") int idClient){
        if (product.getBalance()==0){
            product.setIdProduct(idProduct);
            product.setState("Cancelado");
        }
        else{
            System.out.println("El producto no puede ser cancelado ya que aun dispone de saldo, puede realizar el cambio a inactivo si así lo desea");
        }
        return serviceProduct.cancelProduct(product, idClient);
    }


}
