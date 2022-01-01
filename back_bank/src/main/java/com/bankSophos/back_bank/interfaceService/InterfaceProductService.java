package com.bankSophos.back_bank.interfaceService;

import com.bankSophos.back_bank.model.Product;

import java.util.List;
import java.util.Optional;

public interface InterfaceProductService {
    public List<Product> listIdProduct(int idClient);
    public Optional<Product> listIdOneProduct(int idClient, int idProduct);
    public Optional<Product> listIdOneProduct2(int idClient, int idProduct);
    public Product addProduct(Product product, int idClient);
    public Product changeStatus(Product product, int idClient);
    public Product cancelProduct(Product product, int idClient);
}
