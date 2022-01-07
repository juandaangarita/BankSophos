package com.bankSophos.back_bank.service;

import com.bankSophos.back_bank.interfaceService.InterfaceProductService;
import com.bankSophos.back_bank.interfaceService.InterfaceTransactionService;
import com.bankSophos.back_bank.interfaces.InterfaceProduct;
import com.bankSophos.back_bank.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements InterfaceProductService {

    @Autowired
    private InterfaceProduct dataProduct;

    @Autowired
    InterfaceTransactionService transactionService;

    @Override
    public List<Product> listIdProduct(int idClient) {
        return dataProduct.findByIdClient(idClient);
    }

    @Override
    public Product listIdOneProduct(int idProduct) {
        return dataProduct.findByIdProduct(idProduct);
    }

    @Override
    public Product addProduct(Product product, int idClient) {
        return dataProduct.save(product);
    }

    @Override
    public Product changeStatus(Product product) {
        return dataProduct.save(product);
    }

    @Override
    public Product updateBalance(Product product) {
        return dataProduct.save(product);
    }

    @Override
    public Product cancelProduct(Product product) {
        return dataProduct.save(product);
    }

    @Override
    public Product addToBalance(Product product, int movement) {
        return dataProduct.save(product);
    }

    @Override
    public Product withdrawToBalance(Product product, int movement) {
        return dataProduct.save(product);
    }
}
