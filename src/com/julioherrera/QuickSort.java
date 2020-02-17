package com.julioherrera;

/**
 * QuickSort
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

public class QuickSort implements Sort {

    public QuickSort() {}

    public Comparable[] sort(Comparable[] numbersToOrder) {
        numbersToOrder = quick(numbersToOrder, 0, numbersToOrder.length - 1);
        return numbersToOrder;
    }

    /*
     * Este sort va poniendo los mayores de lado derecho y los menores del izquierdo
     * Usa recursividad para llegar al ultimo nivel de ordenamiento de la lista
     * Inspirado en Ordenamiento Quicksort (Rápido!) en Java de: Jorge - CodigoFacilito
     * https://www.youtube.com/watch?v=yXy7WzgUaSA
     * pre: r es la ultima posicion de la lista
     * post: --
     * @param numbers es la lista a ordenar
     * @param l es la posicion desde la que se comprobara de lado izquierdo
     * @param r es la poosicion hasta la que se comprobara de lado derecho
     * @return La lista ya ordenada
     * */
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
