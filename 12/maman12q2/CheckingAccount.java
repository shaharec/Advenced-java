package com.company;

public abstract class CheckingAccount extends BankAccount{

    public CheckingAccount(String account_num, String owner_name, String id, double balance) {
        super(account_num, owner_name, id, balance);
    }
    // Write a check by taking money from the account.
    public void writeCheck(double amount) throws IllegalBalance{
        super.withdraw(amount);
    }

}
