package com.company;

public class AccountLine {
    // The object represent a  line the the finale account of the consumer.

    private Item _item; // Item identifier.
    private double _totalPrice; // total Peice of line = Item-price * amount.
    private int _amount; // Amount of item.

    public AccountLine(Item item, int amount){
        _item = item;
        _amount = amount;
        _totalPrice = _amount * item.getPrice();
    }
    // Returns the string of Line
    @Override
    public String toString(){
        return "Item: "+_item.getName()+ " amount: "+ _amount +" price: " +_totalPrice;
    }

    public double getLinePrice(){
        return _totalPrice;
    }

}
