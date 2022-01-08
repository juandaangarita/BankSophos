package com.bankSophos.back_bank.model;

import javax.persistence.*;

@Entity
@Table(name ="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    @JoinColumn(name = "id")
    private int idClient;
    private String typeAccount;
    private String numberAccount;
    private String creationDate;
    private String state;
    private double balance;

    public Product() {
    }

    public Product(int idProduct, int idClient, String typeAccount, String numberAccount, String creationDate, String state, double balance) {
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.typeAccount = typeAccount;
        this.numberAccount = numberAccount;
        this.creationDate = creationDate;
        this.state = state;
        this.balance = balance;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
