package com.julioherrera;

public class Number implements Comparable<Number> {

    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Number o) {
        if (value > o.getValue()) {
            return 1;
        } else if (value < o.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static Number parseNumber(String string) {
        Number number = new Number(Integer.parseInt(string));
        return number;
    }
}
