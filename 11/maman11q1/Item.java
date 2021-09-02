package com.company;

public class Item {
    private double _price;
    private String _name;

    public Item(String name,double price){
        _price = price;
        _name = name;
    }

    public double getPrice(){
        return _price;
    }

    public String getName(){
        return _name;
    }
}
