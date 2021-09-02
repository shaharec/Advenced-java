package com.company;

public abstract class  BankAccount {

    private String account_num; // Account number
    private String owner_name; // Bank account owner name.
    private String id; // owner id.
    private double balance; // Balance in the account.

    public BankAccount(String account_num, String owner_name,String id, double balance){
        this.account_num = account_num;
        this.owner_name = owner_name;
        this.id = id;
        this.balance = balance;
    }
    public void addToBalance(double amount){
        this.balance += amount;
    }

    // Take mony from the account balance.
    // If there is non throw exception.
    public void withdraw(double amount) throws IllegalBalance {
        if(this.balance-amount<0)
            throw new IllegalBalance("Illegal balance after the withdraw entered");
        else this.balance -= amount;
    }

    public abstract void monthlyManage() throws IllegalBalance;

    @Override
    public boolean equals(Object o){
        BankAccount b = (BankAccount)o;
        if(this.account_num.equals(b.getAccount_num())&& this.owner_name.equals(b.getOwner_name()) &&
                this.id.equals(b.getId()) && this.balance == b.getBalance())
            return true;
        return false;

    }
    @Override
    public String toString(){
        return "-------------------------------------" +
                "\nAccount number: " + this.account_num +
                "\nowner_name: "+this.owner_name+
                "\nid: "+ this.id+
                "\nBalance: "+this.balance;

    }
    // Take commission from the account,
    protected void takeCommission(double amount){
        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    };

    public String getAccount_num() {
        return account_num;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
