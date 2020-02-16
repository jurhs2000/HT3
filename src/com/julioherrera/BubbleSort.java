package com.julioherrera;

public class BubbleSort implements Sort {

    public BubbleSort() {}

    public Comparable[] sort(Comparable[] numbersToOrder) {
        for (int i = 0; i < (numbersToOrder.length - 1); i++) {
            for (int j = 0; j < (numbersToOrder.length - i - 1); j++) {
                if (numbersToOrder[j].compareTo(numbersToOrder[j+1]) > 0) {
                    Comparable stored = numbersToOrder[j];
                    numbersToOrder[j] = numbersToOrder[j + 1];
                    numbersToOrder[j + 1] = stored;
                }
            }
        }
        return numbersToOrder;
    }
}
