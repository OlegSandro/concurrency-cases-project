package com.example.starvation;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println("Поток " + name + " запустился");

        MyNumber counter = new MyNumber(0);

        SafeThread th1 = new SafeThread("safe-1", counter);
        SafeThread th2 = new SafeThread("safe-2", counter);

        // Проблема "Голодание"
        /*
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
         */


        // Решение проблемы "Голодание" (установка для голодающего потока приоритета выполнения,
        // равного или выше, чем у выполняющегося потока)
        th1.setPriority(Thread.NORM_PRIORITY);
        th2.setPriority(Thread.NORM_PRIORITY);

        th1.start();
        Thread.sleep(100);
        th2.start();

        Thread.sleep(4_000);
        th2.interrupt();
        Thread.sleep(4_100);
        th1.interrupt();

        System.out.println("Поток " + name + " завершился");
    }
}
