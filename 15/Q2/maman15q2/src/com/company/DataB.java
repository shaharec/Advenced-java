package com.company;

public class DataB implements IData {
  private int x =0;
  private int y = 0;
  private boolean printDiff = false;

    public DataB(int x, int y){
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff(){

        if(!printDiff) {// If there is no new diff wait until update will occur
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int diff = Math.abs(x-y);
        System.out.println("*****Reading****\n"+this.toString()+"\nDiff: "+Math.abs(x-y));
        printDiff = false; // New diff was printed
        notify(); // Notify the update threads.
        return diff;
    }

    public synchronized void update(int dx, int dy){
        if(printDiff) { // If the current values weren't printed wait.
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        x = x + dx;
        y = y + dy;
        printDiff = true; // Values were updated and need to be printed.
        System.out.println("****Writing****\ndx: "+dx+" dy: "+dy+"\n"+this.toString());
        notify(); // Notify getDiff.
    }

    public String toString(){
        return "X: "+this.x+" Y: "+this.y;
    }

}
