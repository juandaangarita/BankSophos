package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Product;

import java.util.List;

public interface InterfaceProductService {
    public List<Product> listIdProduct(int idClient);
    public Product listIdOneProduct(int idProduct);
    public Product addProduct(Product product, int idClient);
    public Product changeStatus(Product product);
    public Product cancelProduct(Product product);
    public Product addToBalance(Product product, int movement);
}
