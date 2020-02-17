package com.julioherrera;

/**
 * RadixSort.
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

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
        //Va cambiando de unidades a decenas, centenas... etc.
        //Si el maximo es dividido por una unidad mayor dara un decimal, lo cual es menor a cero y saldra del ciclo
        for (int i = 1; Math.abs(max/i) > 0; i *= 10) {
            numbersToOrder = radix(numbersToOrder, numbersToOrder.length, i); //envia la unidad que se trabajara
        }
        numbersToOrder = orderNegatives(numbersToOrder);
        return numbersToOrder;
    }

    /*
     * radix, ejecuta el ordenamiento de una unidad (decena, centena, etc) para toda la lista
     * pre: exp tienen que ser multiplos de 10
     * post: --
     * @param array es la lista de numeros
     * @param n es el tamaño de la lista
     * @param es la potencia que se trabajara
     * @return La lista ordenada, pero no en cuanto a signos
     * */
    private int[] radix(int[] array, int n, int exp) {
        int newArray[] = new int[n];
        int i;
        int count[] = new int[10];
        //Mete la unidad en su respectiva casilla, por eso son 10, por el sistema decimal
        for (i = 0; i < n; i++) {
            count[ Math.abs(array[i]/exp)%10 ]++;
        }
        //Suma las casillas para dar con un total igual al tamaño del array
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        //Desde el ultimo numero, obtiene la unidad que se esta trabajando y lo ingresa en una respectiva posicion
        //Segun el contador de unidades
        for (i = n - 1; i >= 0; i--) {
            newArray[count[ Math.abs(array[i]/exp)%10 ] - 1] = array[i];
            count[ Math.abs(array[i]/exp)%10 ]--;
        }
        //iguala el array
        for (i = 0; i < n; i++) {
            array[i] = newArray[i];
        }
        return array;
    }

    /*
     * Ordena los negativos y positivos
     * pre: numbersToOrder es una lista ordenada en unidades pero no en signos
     * post: Devuelve una lista totalmente ordenada
     * @param numbers es la lista
     * @return La lista ya ordenada
     * */
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

    /*
     * Obtiene el maximo numero de la lista
     * pre: array es una lista de ints. size es el tamaño de la lista (sin modificaciones)
     * post: --
     * @param array es la lista
     * @param size es el tamaño de la lista
     * @return el maximo de la lista
     * */
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
