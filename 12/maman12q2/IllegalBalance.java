package com.company;

public class IllegalBalance extends Exception{
    public IllegalBalance(String str){
        super("Illegal balance was entered");
    }
}
