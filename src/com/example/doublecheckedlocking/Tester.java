package com.example.doublecheckedlocking;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println(name + " запустился");

        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th2.start();

        Thread.sleep(6_000);

        System.out.println(name + " завершился");
    }
}
