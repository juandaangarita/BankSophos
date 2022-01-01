package com.bankSophos.back_bank.model;

import javax.persistence.*;

@Entity
@Table(name ="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaction;
    @JoinColumn(name = "id")
    private int idPrincipalClient;
    private int idSecondaryClient;
    @JoinColumn(name = "idProduct")
    private int idPrincipalProduct;
    private int IdSecondaryProduct;
    private String typeOperation;
    private int valueOperation;
    private String dateOperation;
    private String description;
    private String resultOperation;
    private String finalBalance;
    private int GMF;

    public Transaction() {
    }

    public Transaction(int idTransaction, int idPrincipalClient, int idSecondaryClient, int idPrincipalProduct, int idSecondaryProduct, String typeOperation, int valueOperation, String dateOperation, String description, String resultOperation, String finalBalance, int GMF) {
        this.idTransaction = idTransaction;
        this.idPrincipalClient = idPrincipalClient;
        this.idSecondaryClient = idSecondaryClient;
        this.idPrincipalProduct = idPrincipalProduct;
        IdSecondaryProduct = idSecondaryProduct;
        this.typeOperation = typeOperation;
        this.valueOperation = valueOperation;
        this.dateOperation = dateOperation;
        this.description = description;
        this.resultOperation = resultOperation;
        this.finalBalance = finalBalance;
        this.GMF = GMF;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdPrincipalClient() {
        return idPrincipalClient;
    }

    public void setIdPrincipalClient(int idPrincipalClient) {
        this.idPrincipalClient = idPrincipalClient;
    }

    public int getIdSecondaryClient() {
        return idSecondaryClient;
    }

    public void setIdSecondaryClient(int idSecondaryClient) {
        this.idSecondaryClient = idSecondaryClient;
    }

    public int getIdPrincipalProduct() {
        return idPrincipalProduct;
    }

    public void setIdPrincipalProduct(int idPrincipalProduct) {
        this.idPrincipalProduct = idPrincipalProduct;
    }

    public int getIdSecondaryProduct() {
        return IdSecondaryProduct;
    }

    public void setIdSecondaryProduct(int idSecondaryProduct) {
        IdSecondaryProduct = idSecondaryProduct;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getValueOperation() {
        return valueOperation;
    }

    public void setValueOperation(int valueOperation) {
        this.valueOperation = valueOperation;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResultOperation() {
        return resultOperation;
    }

    public void setResultOperation(String resultOperation) {
        this.resultOperation = resultOperation;
    }

    public String getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(String finalBalance) {
        this.finalBalance = finalBalance;
    }

    public int getGMF() {
        return GMF;
    }

    public void setGMF(int GMF) {
        this.GMF = GMF;
    }
}

