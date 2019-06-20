package com.example.deadlock;

public class SafeThread extends Thread {

    private MyNumber a;
    private MyNumber b;

    public SafeThread(String name, MyNumber a, MyNumber b) {
        super(name);
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println("Поток " + name + " запустился");

        // Код, склонный при некоторых условиях вызывать проблему "Взаимная блокировка"
        /*
        doSomething(a, b);
         */

        // Код, решающий возможную проблему "Взаимная блокировка" (путём задания порядка выполнения блокировки)
        int aHash = a.hashCode();
        int bHash = b.hashCode();

        if(aHash < bHash){
            doSomething(a, b);
        } else {
            doSomething(b, a);
        }

        System.out.println("Поток " + name + " завершился");
    }

    private void doSomething(MyNumber x, MyNumber y){
        synchronized (x){
            try {
                System.out.println(super.getName() + ": sync block 1: enter");
                Thread.sleep(3_000);
                synchronized (y){
                    System.out.println(super.getName() + ": sync block 2: enter");
                    Thread.sleep(5_000);
                    System.out.println(super.getName() + ": sync block 2: exit");
                }
                System.out.println(super.getName() + ": sync block 1: exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
