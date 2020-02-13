package com.julioherrera;

import java.util.Stack;

public class SelectionSort implements Sort {

    public SelectionSort() {}

    public Stack<Number> sort(Stack<Number> numbersToOrder) {
        Number max;
        int newSize = numbersToOrder.size();
        int index = 0;
        while (newSize > 0) {
            max = numbersToOrder.firstElement();
            index = 0;
            for (int i = 1; i < newSize; i++) {
                if (max.compareTo(numbersToOrder.get(i)) == -1) {
                    max = numbersToOrder.get(i);
                    index = i;
                }
            }
            //Swap
            numbersToOrder.setElementAt(numbersToOrder.get(newSize - 1), index);
            numbersToOrder.setElementAt(max, (newSize - 1));
            newSize--;
        }
        return numbersToOrder;
    }
}
