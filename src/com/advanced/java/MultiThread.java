package com.advanced.java;

public class MultiThread {

    int counter = 1;
    static int N = Integer.MAX_VALUE;
    public static void main(String[] args){
        MultiThread obj = new MultiThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEven();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printOdd();
            }
        });

        t1.start();
        t2.start();
    }

    public void printEven(){
        synchronized (this){
            while(counter < N){
                while(counter%2 == 1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }

    public void printOdd(){
        synchronized (this){
            while(counter < N){
                while(counter%2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
}
