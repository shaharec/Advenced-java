package com.company;

import java.util.ArrayList;

public class DataC implements IData {
    private int x;
    private int y;
    private boolean write = false;
    private int readingThreds; // Number of current threads in getDiff


    public DataC(int x, int y){
        this.x = x;
        this.y = y;
        this.readingThreds = 0;

    }

    public int getDiff(){

        this.waitUntilFinishWrite(); // Wait until no thread is updating data.
        this.setRead(true); // Staet reading.
        System.out.println("*****Reading****\n"+this.toString()+"\nDiff: "+Math.abs(x-y));
        int diff = Math.abs(x-y);
        this.setRead(false); // Finish reading.
        return diff;
    }

    private synchronized void setRead(Boolean read){
        if(read) // If a new thread entered the getDiff update readingThereads, else reduce.
            this.readingThreds++;
        else {
            this.readingThreds--;
            if(this.readingThreds == 0)// Notify writers only if all threads are finish reading getDiff.
                notifyAll();
        }
    }


    private synchronized void waitUntilFinishWrite() {
        while(write){ // Wait until finish updating the class;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void update(int dx, int dy){

        waitUntilFinishReading();
        setWrite(true); // Start writing
        x = x + dx;
        y = y + dy;
        System.out.println("****Writing****\ndx: "+dx+" dy: "+dy+"\n"+this.toString());
        setWrite(false); // finish writing.
        notifyAll(); // Notify all readers.
    }

    private synchronized void setWrite(Boolean write){
        this.write = write;
    }

    private synchronized void waitUntilFinishReading() {// Wait until no one is reading the data.
        while(this.readingThreds>0) { // If there is one or more thread in get diff wait.
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString(){
        return "X: "+this.x+" Y:"+this.y;
    }



}
