package com.example.doublecheckedlocking;

public class Conveyor {

    private String name;
    private int workersAmount;

    public Conveyor() {
    }

    public Conveyor(String name, int workersAmount) {
        this.name = name;
        this.workersAmount = workersAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkersAmount() {
        return workersAmount;
    }

    public void setWorkersAmount(int workersAmount) {
        this.workersAmount = workersAmount;
    }
}
