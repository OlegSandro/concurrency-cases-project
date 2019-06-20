package com.example.deadlock;

public class MyNumber {

    private long value;

    public MyNumber(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void incrementValue(){
        value++;
    }

    public void addValue(MyNumber b){
        value = value + b.getValue();
    }
}
