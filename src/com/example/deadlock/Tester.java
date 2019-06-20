package com.example.deadlock;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println("Поток " + name + " запустился");

        MyNumber a = new MyNumber(6);
        MyNumber b = new MyNumber(3);

        SafeThread th1 = new SafeThread("thread-1", a, b);
        SafeThread th2 = new SafeThread("thread-2", b, a);

        th1.start();
        th2.start();

        Thread.sleep(20_000);

        System.out.println("Поток " + name + " завершился");
    }
}
