package com.example.doublecheckedlocking;

public class BadPlant {

    private Conveyor conveyor;

    public BadPlant() {
    }

    public synchronized Conveyor getConveyor(){
        if(conveyor == null){
            conveyor = new Conveyor("Конвейер № 1", 17);
        }
        return conveyor;
    }
}
