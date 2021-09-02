package com.company;

public class HighInterestSavings extends SavingsAccount{

    private final double min_balance_def = 2; // Minimum balance allowed default.
    private double min_balance; // Actual minimum balance.
    private final double interset_def = 11; // Default for interset rate.

    public HighInterestSavings(String account_num, String owner_name, String id, double balance) throws Exception {
        super(account_num, owner_name, id, balance);
        this.setInterest(interset_def);
        this.min_balance = min_balance_def;
    }
    public HighInterestSavings(String account_num, String owner_name, String id, double balance,double min_balance,double interset) throws Exception {
        super(account_num, owner_name, id, balance,interset);
        this.min_balance = min_balance;
    }

    @Override
    // Withdraw money if the balance-amount is bigger then minimum balance.
    public void withdraw(double amount) throws IllegalBalance {
        if(this.getBalance()-amount<this.min_balance)
            throw new IllegalBalance("Illegal balance after the withdraw entered");
        else this.setBalance(this.getBalance()-amount);
    }

    public double getMin_balance() {
        return min_balance;
    }

    public void setMin_balance(double min_balance) {
        this.min_balance = min_balance;
    }

    @Override
    public boolean equals(Object o){
        HighInterestSavings h = (HighInterestSavings) o;
        if(h.getMin_balance()==this.min_balance &&
                h.getInterest() == this.getInterest() &&
                super.equals(o) )
            return true;
        return false;
    }



    public String toString(){
        return super.toString()+"\nMin balance:"+this.min_balance;
    }
}
