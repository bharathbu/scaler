package com.advanced.dsa.multithreading.executors;

public class NumberPrinter implements Runnable{

    private int number;

    public NumberPrinter(int n){
        this.number = n;
    }
    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Number: " + number + ", printed from thread: " + Thread.currentThread());
    }
}
