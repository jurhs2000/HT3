package com.julioherrera;

import java.util.Vector;

public class SelectionSort implements Sort {

    public SelectionSort() {}

    public Comparable[] sort(Comparable[] numbersToOrder) {
        Comparable max;
        int newSize = numbersToOrder.length;
        int index = 0;
        while (newSize > 0) {
            max = numbersToOrder[0];
            index = 0;
            for (int i = 1; i < newSize; i++) {
                if (max.compareTo(numbersToOrder[i]) == -1) {
                    max = numbersToOrder[i];
                    index = i;
                }
            }
            //Swap
            numbersToOrder[index] = numbersToOrder[newSize - 1];
            numbersToOrder[newSize - 1] = max;
            newSize--;
        }
        return numbersToOrder;
    }
}
