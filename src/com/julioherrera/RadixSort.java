package com.julioherrera;

import java.util.Arrays;

public class RadixSort implements Sort {

    public RadixSort() {}

    //No implementado ya que este sort solo ordena numeros y no comparables en si.
    public Comparable[] sort(Comparable[] numbersToOrder) {
        return null;
    }

    //Sorting inspirado en RadixSort: DrRoot_ & rathbhupendra - GeeksForGeeks
    //https://www.geeksforgeeks.org/radix-sort/
    public int[] sort(int[] numbersToOrder) {
        int max = getMax(numbersToOrder, numbersToOrder.length);
        for (int i = 1; Math.abs(max/i) > 0; i *= 10) {
            numbersToOrder = radix(numbersToOrder, numbersToOrder.length, i);
        }
        numbersToOrder = orderNegatives(numbersToOrder);
        return numbersToOrder;
    }

    private int[] radix(int[] array, int n, int exp) {
        int newArray[] = new int[n];
        int i;
        int count[] = new int[10];

        for (i = 0; i < n; i++) {
            count[ Math.abs(array[i]/exp)%10 ]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            newArray[count[ Math.abs(array[i]/exp)%10 ] - 1] = array[i];
            count[ Math.abs(array[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++) {
            array[i] = newArray[i];
        }
        return array;
    }

    private int[] orderNegatives(int[] numbers) {
        int[] negatives = new int[numbers.length];
        int contN = 0;
        int contP = (numbers.length - 1);
        for (int i = (numbers.length - 1); i >= 0; i--) {
            if (numbers[i] < 0) {
                negatives[contN] = numbers[i];
                contN++;
            } else {
                negatives[contP] = numbers[i];
                contP--;
            }
        }
        return negatives;
    }

    private int getMax(int[] array, int size) {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
