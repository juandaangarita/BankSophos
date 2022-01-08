package com.bankSophos.back_bank.interfaces;

import com.bankSophos.back_bank.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceProduct extends JpaRepository<Product, Integer> {

    List<Product> findByIdClient(int idClient);

    Product findByIdProduct(int idProduct);

    //@Query("select * from products where (state!=?) AND NOT (id_client=? and id_product=?)")
    List<Product> findByStateNotAndIdClientNotAndIdProductNot(String state, int idClient, int idProduct);
}
