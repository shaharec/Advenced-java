package com.company;

public class ServiceChargeChecking extends CheckingAccount{

    private final double commission_default = 10; // Default commission.
    private double commission; // Actual commission in the account.

    public ServiceChargeChecking(String account_num, String owner_name, String id, double balance) {
        super(account_num, owner_name, id, balance);
        this.commission = this.commission_default;
    }
    public ServiceChargeChecking(String account_num, String owner_name, String id, double balance,double commission) {
        super(account_num, owner_name, id, balance);
        this.commission = commission;
    }
    @Override
    // Take commission from account
    public void monthlyManage()  {
        this.takeCommission(this.commission);
    }
    public void setCommission(double new_commission){
        this.commission = new_commission;
    }

    public double getCommission(){ return this.commission;}

    @Override
    public boolean equals(Object o){
        ServiceChargeChecking sc = (ServiceChargeChecking) o;
        return sc.getCommission() == this.commission && super.equals(o);
    }
    @Override
    public String toString(){
        return super.toString()+"\nCommission: "+this.commission;
    }
}
