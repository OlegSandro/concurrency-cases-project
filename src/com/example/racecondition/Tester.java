package com.example.racecondition;

public class Tester {

    public static void main(String[] args){
        String name = Thread.currentThread().getName();
        System.out.println("Поток " + name + " запустился");

        MyNumber counter = new MyNumber(0);

        /*
        Задача: последовательно выводить в консоль увеличение счётчика counter
         */

        // Проблема "Состояние гонки"
        /*
        UnsafeThread th1 = new UnsafeThread("unsafe-1", counter);
        UnsafeThread th2 = new UnsafeThread("unsafe-2", counter);
         */

        // Решение проблемы "Состояние гонки" (использование блока synchronized)
        SafeThread th1 = new SafeThread("safe-1", counter);
        SafeThread th2 = new SafeThread("safe-2", counter);

        th1.start();
        th2.start();

        System.out.println("Поток " + name + " завершился");
    }
}
