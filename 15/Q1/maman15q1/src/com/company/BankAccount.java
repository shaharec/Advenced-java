package com.company;

public class BankAccount {

    private int ID;
    private double balance;

    public BankAccount(double balance,int ID) {
        this.balance = 0;
        this.ID = ID;
    }
    public synchronized void  transaction(double amount){
        while (this.balance + amount<0) // As long as there is not enough balance.
            try { this.wait(); } // Go to sleep and wait for one of the other bak tellers to add money to the account.
            catch (InterruptedException e) { }
        this.balance += amount;
        printTransaction(amount); // Print transaction after preforming.
        this.notifyAll(); // notify all threads.
    }

    private void printTransaction(double amount) {
        System.out.println("\n*******Transaction preformed****\n"+
                "Bank teller: "+Thread.currentThread().getName()+
                "\nBand ID:" +this.ID+
                "\nAmount: "+ amount+
                "\nOld balance: " + (this.balance-amount) +
                "\nNew balance: " + this.balance);
    }

    public int getID(){
        return this.ID;
    }

    public String toString(){
        return "ID: "+this.ID+ " balance: "+this.balance;
    }

}
