package com.company;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Iterator;

public class BankTransactions {
    private ArrayList <BankTransaction> transactions;

    public BankTransactions(ArrayList<BankTransaction> transactions){
        this.transactions = new ArrayList<>(transactions);
    }
    public BankTransactions(){
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(int id,double amount){
        transactions.add(new BankTransaction(id,amount));
    }
    public synchronized BankTransaction getTransaction(){
        if ( this.transactions.size()>0)
            return this.transactions.remove(0);
        return null;
    }

    public String toString(){
        String str = "**********Transactions to preform:**********\n";
        Iterator it = this.transactions.iterator();
        while(it.hasNext()){
            BankTransaction btr = (BankTransaction) it.next();
            str += btr+"\n";
        }
        return str;
    }

}
