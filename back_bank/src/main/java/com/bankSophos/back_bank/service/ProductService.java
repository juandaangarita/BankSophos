package com.bankSophos.back_bank.service;

import com.bankSophos.back_bank.interfaceService.InterfaceProductService;
import com.bankSophos.back_bank.interfaces.InterfaceProduct;
import com.bankSophos.back_bank.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements InterfaceProductService {

    @Autowired
    private InterfaceProduct dataProduct;

    @Override
    public List<Product> listIdProduct(int idClient) {
        return dataProduct.findByIdClient(idClient);
    }


    @Override
    public Optional<Product> listIdOneProduct(int idClient, int idProduct) {
        return dataProduct.findById(idProduct);
    }

    @Override
    public Optional<Product> listIdOneProduct2(int idClient, int idProduct) {
        return dataProduct.findById(idProduct);
    }

    @Override
    public Product addProduct(Product product, int idClient) {
        return dataProduct.save(product);
    }

    @Override
    public Product changeStatus(Product product, int idClient) {
        return dataProduct.save(product);
    }

    @Override
    public Product cancelProduct(Product product, int idClient) {
        return dataProduct.save(product);
    }
}
