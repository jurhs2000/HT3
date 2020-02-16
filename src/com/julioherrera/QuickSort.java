package com.julioherrera;

public class QuickSort implements Sort {

    public QuickSort() {}

    public Comparable[] sort(Comparable[] numbersToOrder) {
        numbersToOrder = quick(numbersToOrder, 0, numbersToOrder.length - 1);
        return numbersToOrder;
    }

    //Inspirado en Ordenamiento Quicksort (Rápido!) en Java de: Jorge - CodigoFacilito
    //https://www.youtube.com/watch?v=yXy7WzgUaSA
    private Comparable[] quick(Comparable[] numbers, int l, int r) {
        if (l >= r) {
            return numbers;
        }
        int left = l;
        int right = r;
        Comparable toChange;
        Comparable pivot = numbers[left];
        while (left != right) {
            while ((numbers[right].compareTo(pivot)) > -1  && left < right) {
                right--;
            }
            while ((numbers[left].compareTo(pivot)) < 0  && left < right) {
                left++;
            }
            if (left != right) {
                toChange = numbers[right];
                numbers[right] = numbers[left];
                numbers[left] = toChange;
            }
        }
        if (left == right) {
            quick(numbers, l, left);
            quick(numbers, left + 1, r);
        }
        return numbers;
    }
}
