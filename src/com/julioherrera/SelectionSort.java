package com.julioherrera;

/**
 * SelectionSort.
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

public class SelectionSort implements Sort {

    public SelectionSort() {}

    public Comparable[] sort(Comparable[] numbersToOrder) {
        Comparable max;
        int newSize = numbersToOrder.length;
        int index = 0;
        while (newSize > 0) {
            max = numbersToOrder[0]; //Toma el primero como el mayor
            index = 0;
            for (int i = 1; i < newSize; i++) {
                if (max.compareTo(numbersToOrder[i]) == -1) { //Compara el maximo actual con el iterador
                    max = numbersToOrder[i]; //Si es mayor el nuevo numero se cambia el maximo
                    index = i; //se guarda la posicion del nuevo mayor
                }
            }
            //Swap: Se cambian el nuevo maximo a la ultima posicion
            numbersToOrder[index] = numbersToOrder[newSize - 1];
            numbersToOrder[newSize - 1] = max;
            newSize--; //Se va reduciendo la cantidad de numeros a ordenar
        }
        return numbersToOrder;
    }
}
