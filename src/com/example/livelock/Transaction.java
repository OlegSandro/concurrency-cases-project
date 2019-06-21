package com.example.livelock;

public class Transaction extends Thread {

    private BankAccount fromAccount;
    private BankAccount toAccount;
    private double amount;

    public Transaction(String name, BankAccount fromAccount, BankAccount toAccount, double amount) {
        super(name);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " начал работу");
        try {
            fromAccount.tryTransfer(toAccount, 10);
            System.out.println(name + ": деньги перечислены");
        } catch (InterruptedException e) {
        }
        System.out.println(name + " завершил работу");
    }
}
