package com.company;

public class InterestChecking extends NoServiceChargeChecking {

    private final double min_balance_def = 5; // Minimum balance default amount.
    private final double interest_def = 5; // Default interest amount.The interest is in percentage.
    private double interest; // Actual interest in the account.

    public InterestChecking(String account_num, String owner_name, String id, double balance) {
        super(account_num, owner_name, id, balance);
        super.setMin_balance(this.min_balance_def);
        this.interest = this.interest_def;
    }

    public InterestChecking(String account_num, String owner_name, String id, double balance,double min_balcnce, double interest) {
        super(account_num, owner_name, id, balance,min_balcnce);
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
        InterestChecking i = (InterestChecking) o;
        if(this.interest == i.getInterest() && super.equals(o))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+"\ninterest: " + interest;
    }
}
