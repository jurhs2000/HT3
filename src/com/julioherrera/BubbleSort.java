package com.julioherrera;

/**
 * BubbleSort.
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

public class BubbleSort implements Sort {

    public BubbleSort() {}

    /*
     * Este sort comprueba cada numero con cada uno de los que restan, desde la izquierda
     * pre: numbersToMerge es una lista de comparables
     * post: --
     * @param numbersToOrder es la lista que se va a ordenar
     * @return una lista ya ordenada
     * */
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
