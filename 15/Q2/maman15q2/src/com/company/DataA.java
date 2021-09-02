package com.company;

public class DataA implements IData{
  private int x =0;
  private int y = 0;

    public DataA(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getDiff(){
        System.out.println("*****Reading****\n"+this.toString()+"\nDiff: "+Math.abs(x-y));
        return (Math.abs(x-y));
    }

    public void update(int dx, int dy) {
        x = x + dx;
        y = y + dy;
        System.out.println("****Writing****\ndx: " + dx + " dy: " + dy + "\n" + this.toString());
    }

    public String toString(){
        return "X: "+this.x+" Y: "+this.y;
    }

}
