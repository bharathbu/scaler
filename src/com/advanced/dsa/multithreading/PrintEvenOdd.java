package com.advanced.dsa.multithreading;

class PrintEvenOddTask{

    int iterator=1;
    static int printTill;

    public void printEven() throws InterruptedException {
        synchronized (this){
            while(iterator<printTill){
                if(iterator%2 !=0)
                    wait();
                System.out.println(iterator);
                iterator++;
                notify();
            }
        }
    }

    public void printOdd() throws InterruptedException {
        synchronized (this){
            while(iterator<printTill){
                if(iterator%2 ==0)
                    wait();
                System.out.println(iterator);
                iterator++;
                notify();
            }
        }
    }
}
public class PrintEvenOdd {

    public static void main(String[] args) throws InterruptedException {
        PrintEvenOddTask obj = new PrintEvenOddTask();
        PrintEvenOddTask.printTill = 10;
        Thread oddThread =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread evenThread =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
