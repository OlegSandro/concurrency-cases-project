package com.example.livelock;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread. currentThread().getName();
        System.out.println(name + " начал работу");

        BankAccount account1 = new BankAccount(1, 100);
        BankAccount account2 = new BankAccount(2, 100);

        Transaction th1 = new Transaction("thread-1", account1, account2, 10);
        Transaction th2 = new Transaction("thread-2", account2, account1, 10);

        th1.start();
        th2.start();

        for(int i=0; i<6; i++)
            if(th1.isAlive() || th2.isAlive())
                Thread.sleep(5_000);

        if(th1.isAlive())
            th1.interrupt();
        if(th2.isAlive())
            th2.interrupt();

        System.out.println(name + " завершил работу");
    }
}
