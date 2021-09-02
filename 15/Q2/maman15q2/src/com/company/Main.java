/**
 * Student: Shahar Cohen.
 * ID: 313566077*/
package com.company;

public class Main {
    private static final int numberOfReadersWriters = 4;

    public static void main(String[] args) {
	// write your code here
        IData dt;
        MyThread t1,t2,t3,t4;
        // Part 1 - Simple update and get diff with threads.
//        dt = new DataA(10,10);
//        t1 = new MyThread(dt,true);
//        t2 = new MyThread(dt,false);
//        t1.start();
//        t2.start();
//
//        // Part 2 - Syncronized update and read with threads.
//        dt = new DataB(10,10);
//        t3 = new MyThread(dt,true);
//        t4 = new MyThread(dt,false);
//        t3.start();
//        t4.start();

        // Part 3  - One writer, multiple readers.
        MyThread [] readers = new MyThread[numberOfReadersWriters];
        MyThread [] writers = new MyThread[numberOfReadersWriters];
        dt = new DataC(10,10);
        for(int i = 0;i<numberOfReadersWriters;i++){
            writers[i] = new MyThread(dt,true);
            writers[i].start();
            readers[i] = new MyThread(dt,false);
            readers[i].start();
        }


    }
}
