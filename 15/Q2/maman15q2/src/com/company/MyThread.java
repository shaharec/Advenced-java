package com.company;

public class MyThread extends Thread{

    private IData data;
    private Boolean update;
    private final int threadIteratoinNum = 10; // number Of updates/print diff
    private final int sleepingTime = 5;

    public MyThread(IData data, Boolean update){
        this.data = data;
        this.update = update;
    }

    @Override
    public void run(){
        if(update){ // If the thread is a writer.
         for(int i = 0; i< threadIteratoinNum; i++){
            updateData();
         }
        }else { // If the thread is a reader.
            for (int i = 0; i < threadIteratoinNum; i++) {
                printDiff();
            }
        }
    }

    private void printDiff(){ // Print diff in Data and go to sleep.
            this.data.getDiff();
            try {
                this.sleep(this.sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    private void updateData(){ // Update Data and go to sleep.

        this.data.update((int)(Math.random()*10),(int)(Math.random()*10));
        try {
            this.sleep(this.sleepingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

