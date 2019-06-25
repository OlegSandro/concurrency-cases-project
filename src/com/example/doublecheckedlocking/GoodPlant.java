package com.example.doublecheckedlocking;

public class GoodPlant {

    private volatile Conveyor conveyor;

    public GoodPlant() {
    }

    public Conveyor getConveyor(){
        Conveyor refConveyor = conveyor;
        if(refConveyor == null){
            synchronized (this){
                refConveyor = conveyor;
                if(refConveyor == null){
                    conveyor = refConveyor = new Conveyor("Конвейер № 1", 17);
                }
            }
        }
        return refConveyor;
    }
}
