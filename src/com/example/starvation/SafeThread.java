package com.example.starvation;

public class SafeThread extends Thread {

    private MyNumber counter;

    public SafeThread(String name, MyNumber counter) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println("Поток " + name + " запустился");

        while(!isInterrupted()){
            synchronized (counter){
                try {
                    Thread.sleep(500);
                    counter.incrementValue();
                    System.out.println(name + ": " + counter);
                } catch (InterruptedException e) {
                    break;
                }
            }

        }

        System.out.println("Поток " + name + " завершился");
    }
}
