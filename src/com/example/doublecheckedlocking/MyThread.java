package com.example.doublecheckedlocking;

public class MyThread extends Thread {

    public MyThread() {
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " запустился");

        // Код может привести к ошибкам в многопоточном приложении, когда один поток начал инициализацию объекта
        // в то время, как другой поток обнаружил это и стал использовать объект, который мог не полностью быть
        // проинициализирован
        /*
        BadPlant plant = new BadPlant();

        // Блокировка с двойной проверкой решает проблему, описанную выше
         */
        GoodPlant plant = new GoodPlant();
        Conveyor conveyor = plant.getConveyor();

        System.out.println(name + " завершился");
    }
}
