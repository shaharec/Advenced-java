package com.company;

import javax.management.ObjectName;

public class NoServiceChargeChecking extends CheckingAccount{

    private final double min_balance_def = 2; // Minimum balance default amount.
    private double min_balance; // Actual Minimum balance.

    public NoServiceChargeChecking(String account_num, String owner_name, String id, double balance) {
        super(account_num, owner_name, id, balance);
        this.min_balance = this.min_balance_def;
    }
    public NoServiceChargeChecking(String account_num, String owner_name, String id, double balance,double min_balance) {
        super(account_num, owner_name, id, balance);
        this.min_balance = min_balance;
    }

    @Override
    // Widthrow money from account, if there is less the minimum account balance throe exception.
    public void withdraw(double amount) throws IllegalBalance {
        if(this.getBalance()-amount<this.min_balance)
            throw new IllegalBalance("Illegal balance after the withdraw entered");
        else this.setBalance(this.getBalance()-amount);
    }
    @Override
    public void monthlyManage() {

    }

    public double getMin_balance() {
        return min_balance;
    }

    public void setMin_balance(double min_balance) {
        this.min_balance = min_balance;
    }

   @Override
    public boolean equals(Object o){
        NoServiceChargeChecking ns = (NoServiceChargeChecking) o;
        return ns.getMin_balance() == this.min_balance && super.equals(o);
    }
    @Override
    public String toString(){
        return super.toString()+"\nMin balance: "+this.min_balance;
    }
}
