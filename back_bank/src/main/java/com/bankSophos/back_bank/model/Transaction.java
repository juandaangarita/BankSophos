package com.bankSophos.back_bank.model;

import javax.persistence.*;

@Entity
@Table(name ="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaction;
    @JoinColumn(name = "idProduct")
    private int idPrincipalProduct;
    private int idSecondaryProduct;
    private String typeOperation;
    private double valueOperation;
    private String dateOperation;
    private String description;
    private String resultOperation;
    private double finalBalance;
    private double GMF;
    private String financeMovement;

    public Transaction() {
    }

    public Transaction(int idTransaction, int idPrincipalProduct, int idSecondaryProduct, String typeOperation, double valueOperation, String dateOperation, String description, String resultOperation, double finalBalance, double GMF, String financeMovement) {
        this.idTransaction = idTransaction;
        this.idPrincipalProduct = idPrincipalProduct;
        this.idSecondaryProduct = idSecondaryProduct;
        this.typeOperation = typeOperation;
        this.valueOperation = valueOperation;
        this.dateOperation = dateOperation;
        this.description = description;
        this.resultOperation = resultOperation;
        this.finalBalance = finalBalance;
        this.GMF = GMF;
        this.financeMovement = financeMovement;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdPrincipalProduct() {
        return idPrincipalProduct;
    }

    public void setIdPrincipalProduct(int idPrincipalProduct) {
        this.idPrincipalProduct = idPrincipalProduct;
    }

    public int getIdSecondaryProduct() {
        return idSecondaryProduct;
    }

    public void setIdSecondaryProduct(int idSecondaryProduct) {
        this.idSecondaryProduct = idSecondaryProduct;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getValueOperation() {
        return valueOperation;
    }

    public void setValueOperation(double valueOperation) {
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

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public double getGMF() {
        return GMF;
    }

    public void setGMF(double GMF) {
        this.GMF = GMF;
    }

    public String getFinanceMovement() {
        return financeMovement;
    }

    public void setFinanceMovement(String financeMovement) {
        this.financeMovement = financeMovement;
    }
}

