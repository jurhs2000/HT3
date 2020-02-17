package com.julioherrera;

/**
 * Sort interface.
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

public interface Sort {

    /*
    * Esta interfaz impone el metodo sort, que sera invocado para ordenar en cada sort
    * pre: numbersToOrder es una lista de Comparable
    * post: --
    * @param numbersToOrder es la lista que se va a ordenar
    * @return La lista ya ordenada
    * */
    public Comparable[] sort(Comparable[] numbersToOrder);
}
