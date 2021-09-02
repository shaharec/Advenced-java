package com.company;

public class SavingsAccount extends BankAccount{

    private final double interest_def = 5; // The interest is in presented.
    private double interest; // Actual interest in the account.

    public SavingsAccount(String account_num, String owner_name, String id, double balance) {
        super(account_num, owner_name, id, balance);
        this.interest = this.interest_def;
    }

    public SavingsAccount(String account_num, String owner_name, String id, double balance, double interest) {
        super(account_num, owner_name, id, balance);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    // Set interest. the interset is a number that represent percentage and must be between 0-100.
    public void setInterest(double interest) throws Exception {
        if(interest<0 || interest>100)
            throw new Exception("Ileagal interest");
        this.interest = interest;
    }
    // Interest amount = interest ins percentage * account balance.
    public double calcInterst(){
        return (this.interest/100)*this.getBalance();
    }

    @Override
    // Add the interest to account balance.
    public void monthlyManage() {
        this.addToBalance(this.calcInterst());
    }

    @Override
    public boolean equals(Object o){
        SavingsAccount sa = (SavingsAccount) o;
        return sa.getInterest() == this.interest && super.equals(o);
    }

    @Override
    public String toString(){
        return super.toString()+"\ninterest: "+this.interest;
    }
}
