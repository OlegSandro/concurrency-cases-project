package com.example.racecondition;

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

        synchronized (counter){
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(1000);
                    System.out.print(name + ": " + counter + " --> ");
                    counter.incrementValue();
                    Thread.sleep(1000);
                    System.out.println(counter);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        System.out.println("Поток " + name + " завершился");
    }
}
