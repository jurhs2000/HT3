package com.julioherrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * MergeSort
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

public class MergeSort implements Sort {

    public MergeSort() {}

    @Override
    public Comparable[] sort(Comparable[] numbersToOrder) {
        //dividir todos los number de stack de una vez
        ArrayList<Stack<Comparable>> stacks = setToArray(numbersToOrder);
        while (stacks.size() > 1) {
            stacks = merge(stacks);
        }
        return (stacks.get(0)).toArray(numbersToOrder);
    }

    /*
     * Este sort va separando la lista y luego ordena comprobando y uniendo los trozos uno por uno
     * haciendolos coda vez mas grandes hasta que solo queda uno ya ordenado
     * pre: numbersToMerge es una arrayList de stacks de comparables de un solo comparable, lo que da un
     *      size de arrayList igual al tamaño de la lista inicial
     * post: Devuelve igualmente un arrayList con stacks dentro
     * @param numbersToMerge es el arraylist de stacks
     * @return un ArrayList de stacks de diferentes tamaños
     * */
    private ArrayList<Stack<Comparable>> merge(ArrayList<Stack<Comparable>> numbersToMerge) {
        ArrayList<Stack<Comparable>> stacks = new ArrayList<>();
        Stack<Comparable> newStack = new Stack<>();
        int total = 0;
        int cont = 0;
        //Va comprobando el 1ro con el 2do, el 3ro con el 4to... etc
        for (int i = 0; i < numbersToMerge.size(); i += 2) {
            if (i < (numbersToMerge.size() - 1)) { //Por si solo queda un stack para comprobar, se ingresa de una (else)
                total = numbersToMerge.get(i).size() + numbersToMerge.get(i+1).size(); //Total de numeros en ambos stack
                while (cont < (total - 1)) { //Mientras todos menos un numero sea comprobado
                    //Si los stacks todavia tienen numeros ambos se sigue con la comprobacion
                    if (numbersToMerge.get(i).size() != 0 && numbersToMerge.get(i+1).size() != 0) {
                        //Si el primero del primero es menor al primero del segundo
                        if ((numbersToMerge.get(i).get(0).compareTo(numbersToMerge.get(i+1).get(0))) < 0) {
                            newStack.add(numbersToMerge.get(i).get(0));
                            numbersToMerge.get(i).remove(0);
                            cont++;
                        //La misma pero al reves
                        } else if ((numbersToMerge.get(i).get(0).compareTo(numbersToMerge.get(i+1).get(0))) > 0) {
                            newStack.add(numbersToMerge.get(i+1).get(0));
                            numbersToMerge.get(i+1).remove(0);
                            cont++;
                        //Si los dos numeros son iguales, se agregan los dos
                        } else {
                            newStack.add(numbersToMerge.get(i).get(0));
                            numbersToMerge.get(i).remove(0);
                            cont++;
                            newStack.add(numbersToMerge.get(i+1).get(0));
                            numbersToMerge.get(i+1).remove(0);
                            cont++;
                        }
                    } else { //Si uno de los stacks ya no tiene numeros para comprobar, los del otro se copiaran
                        break;
                    }
                }
                //Aqui se copian todos los numeros del stack que quedo con uno o mas numeros
                if (numbersToMerge.get(i).size() != 0) {
                    newStack.addAll(numbersToMerge.get(i));
                } else {
                    newStack.addAll(numbersToMerge.get(i+1));
                }
            } else {
                //Si ya solo queda un stack, se copia al ArrayList
                newStack = numbersToMerge.get(i);
            }
            //Se añade el stack actual
            stacks.add(newStack);
            //Se limpia para los siguientes dos
            newStack = new Stack<>();
            cont = 0;
        }
        return stacks;
    }

    //Divide todos los numeros, los ingresa uno en un stack y mete los stacks al ArrayList
    private ArrayList<Stack<Comparable>> setToArray(Comparable[] data) {
        ArrayList<Stack<Comparable>> stacks = new ArrayList<>();
        for (Comparable comp: data) {
            Stack<Comparable> newStack = new Stack<>();
            newStack.add(comp);
            stacks.add(newStack);
        }
        return stacks;
    }

    private Comparable[] toComparable(Stack<Comparable> stack) {
        Comparable[] array = new Comparable[stack.size()];
        int cont = 0;
        for (Comparable comp: stack) {
            array[cont] = comp;
            cont++;
        }
        return  array;
    }
}
