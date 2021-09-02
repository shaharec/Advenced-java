/**
 * Student: Shahar Cohen.
 * ID: 313566077*/

package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Bank {
    private static final int accountNumber = 5; // Number of bank accounts.
    private static final int startId = 400000; // Starting index of bank id.
    private static final int bankTellerNumber = 10; // Number of bank tellers.
    private static final int minRangeAmount = -1000;
    private static final int rangeAmount = 2000;

    public static void main(String[] args) {
        // Create bank accounts.
        ArrayList <BankAccount> ba = new ArrayList<>();
        for(int i = 0;i<accountNumber;i++){
            ba.add(new BankAccount(0,startId+i));
        }

        // Create bank transactions.
        Random rnd = new Random();
        BankTransactions bt= new BankTransactions();
        Iterator it = ba.iterator();
        while(it.hasNext()){
            BankAccount bankAccount = (BankAccount) it.next();
            /**Add transaction with the amount in range between minRange amount to minRange amount+ range amount.*/
            bt.addTransaction(bankAccount.getID(),
                    rnd.nextDouble()*rangeAmount+minRangeAmount);
            bt.addTransaction(bankAccount.getID(),
                    rnd.nextDouble()*rangeAmount+minRangeAmount);
            bt.addTransaction(bankAccount.getID(),
                    rnd.nextDouble()*rangeAmount+minRangeAmount);
         }
        //Print transactions to preform
        System.out.println(bt);

        // Create and start bank tellers.
        BankTeller[] bankTeller = new BankTeller[bankTellerNumber];
        for(int i = 0; i< bankTellerNumber; i++) {
            bankTeller[i] = new BankTeller(bt, ba);
            bankTeller[i].start(); // Run thread.
        }

    }
}
