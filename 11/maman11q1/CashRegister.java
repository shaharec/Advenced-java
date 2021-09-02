package com.company;
import java.util.ArrayList; //array list for the cash refister

public  class CashRegister {

    private double _money; // Money available in the cash register.
    private ArrayList<AccountLine> _account ; // Account items.

    public CashRegister(){
        this._money = 0;
        this._account = new ArrayList<AccountLine>();
    }

    public CashRegister(double start_amount){
        this._money = start_amount;
        this._account = new ArrayList<AccountLine>();

    }

    // Add item to the account items array.
    public void AddItem(Item item, int amount){

        this._account.add(new AccountLine(item,amount));
    }

    // Function to return the bill description
    @Override
    public String toString(){
        String check_desc = "The items bought are:";
        if(this._account.size() == 0)
            return "The account has no items";
        for(int i=0;i<this._account.size();i++)
            check_desc = check_desc + "\n" + _account.get(i);
        return  check_desc;
    }
    // Function to return the check total price
    public double getBillPrice(){
        double bill_price = 0;
        for(int i=0;i<this._account.size();i++)
         bill_price = bill_price +this._account.get(i).getLinePrice();
        return  bill_price;
    }

    // pay the bill
    public double pay(double cash){
        double check_price = getBillPrice();
        double surplus =  cash - check_price;
        this._money += check_price;
        init(this._money); //initial instance values
        return surplus;
    }

    // Initial the cash register with the start amount.
    private void init(double start_amount){
        this._money = start_amount;
        this._account = new ArrayList<AccountLine>();
    }

    // Get cash in the register.
    public double getCash(){
        return this._money;
    }


}
