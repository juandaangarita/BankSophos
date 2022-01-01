package com.bankSophos.back_bank.interfaces;

import com.bankSophos.back_bank.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterfaceProduct extends JpaRepository<Product, Integer> {

    List<Product> findByIdClient(int idClient);
}