package com.company;

public class BankTransaction {
    private int ID;
    private double amount;

    public BankTransaction(int ID,double amount){
        this.amount = amount;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public double getAmount() {
        return amount;
    }

    public String toString(){
        return "ID: " + this.ID + " Amount: "+this.amount;
    }
}
