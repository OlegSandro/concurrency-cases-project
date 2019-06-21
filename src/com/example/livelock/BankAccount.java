package com.example.livelock;

import java.util.concurrent.locks.*;

public class BankAccount {

    private int id;
    private double balance;
    private Lock lock = new ReentrantLock();

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    private boolean decreaseMoney(double amount) throws InterruptedException {
        if(lock.tryLock()){
            Thread.sleep(500);
            balance = balance - amount;
            return true;
        }
        return false;
    }

    private boolean increaseMoney(double amount) throws InterruptedException {
        if(lock.tryLock()){
            Thread.sleep(500);
            balance = balance + amount;
            return true;
        }
        return false;
    }

    public void tryTransfer(BankAccount toAccount, double amount) throws InterruptedException {
        Thread thread = Thread.currentThread();
        while(!thread.isInterrupted()){
            if(this.decreaseMoney(amount)){
                System.out.println(thread.getName() + " пытается выполнить транзакцию, пока " +
                        this.lock.toString().replace("java.util.concurrent.locks.", "") + " | " +
                        toAccount.lock.toString().replace("java.util.concurrent.locks.", ""));
                if(!toAccount.increaseMoney(amount)){
                    this.increaseMoney(amount);
                    this.lock.unlock();
                    this.lock.unlock();
                    //Код, вызывающий проблему "Динамическая взаимоблокировка"
                    /*
                    Thread.sleep(2_000);
                     */
                    // Код, решающий проблему "Динамическая взаимоблокировка" (путём внесения случайной составляющей
                    // в механизм повтора алгоритма)
                    Thread.sleep((long)(Math.random() * 100 * 10));
                    continue;
                }
                toAccount.unlock();
                this.lock.unlock();
                break;
            }
        }
    }

    public void unlock(){
        lock.unlock();
    }
}
