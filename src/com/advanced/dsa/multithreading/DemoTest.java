package com.advanced.dsa.multithreading;

/**
 * Multithreading can be achieved using,
     * 1.Extends thread
     * 2. Implement runnable interface
     * 3. Using anonymous class with lambda expression
 */

//Thread class methods: run() & start()
class Bike extends Thread{
    public void run(){
        for(int i=0;i<5;i++)
            System.out.println("Bike");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Car extends Thread{
    public void run(){
        for(int i=0;i<5;i++)
            System.out.println("Car");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class DemoTest {
    public static void main(String[] args) throws InterruptedException {
        Bike bike = new Bike();
        Car car = new Car();
        car.start();
        Thread.sleep(100);
        bike.start();
    }
}
