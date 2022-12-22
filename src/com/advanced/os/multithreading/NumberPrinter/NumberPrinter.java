package com.advanced.os.multithreading.NumberPrinter;

public class NumberPrinter implements Runnable{

    private int number;

    public NumberPrinter(int num){
        this.number = num;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Number : " + number + ", printed from thread : " +
                Thread.currentThread().getName());


    }
}
