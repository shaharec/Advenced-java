package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class BankTeller extends Thread {
    private BankTransactions transactions;
    private ArrayList<BankAccount> bankAccounts;
    private final int sleepingTime = 100;

    public BankTeller(BankTransactions trans, ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
        this.transactions = trans;
    }

    @Override
    public void run() {
        BankTransaction trans = this.transactions.getTransaction();
        while (trans != null) { // Run until there are no transactions to preform.
            Iterator<BankAccount> it = this.bankAccounts.iterator();
            boolean findMatch = false;
            while (it.hasNext() && !findMatch) { // Find the right bank id to preform transaction
                BankAccount ba = it.next();
                if (ba.getID() == trans.getID()) {
                    findMatch = true;
                    ba.transaction(trans.getAmount()); // Preform transaction.
                    try {
                        Thread.sleep(this.sleepingTime); // go to sleep.
                        trans = this.transactions.getTransaction(); // Get next transaction from transactions list.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
