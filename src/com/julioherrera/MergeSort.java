package com.julioherrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    private ArrayList<Stack<Comparable>> merge(ArrayList<Stack<Comparable>> numbersToMerge) {
        ArrayList<Stack<Comparable>> stacks = new ArrayList<>();
        Stack<Comparable> newStack = new Stack<>();
        int total = 0;
        int cont = 0;
        for (int i = 0; i < numbersToMerge.size(); i += 2) {
            if (i < (numbersToMerge.size() - 1)) {
                total = numbersToMerge.get(i).size() + numbersToMerge.get(i+1).size(); //No esta resibiendo bien en la segunda
                while (cont < (total - 1)) {
                    if (numbersToMerge.get(i).size() != 0 && numbersToMerge.get(i+1).size() != 0) {
                        if ((numbersToMerge.get(i).get(0).compareTo(numbersToMerge.get(i+1).get(0))) < 0) {
                            newStack.add(numbersToMerge.get(i).get(0));
                            numbersToMerge.get(i).remove(0);
                            cont++;
                        } else if ((numbersToMerge.get(i).get(0).compareTo(numbersToMerge.get(i+1).get(0))) > 0) {
                            newStack.add(numbersToMerge.get(i+1).get(0));
                            numbersToMerge.get(i+1).remove(0);
                            cont++;
                        } else {
                            newStack.add(numbersToMerge.get(i).get(0));
                            numbersToMerge.get(i).remove(0);
                            cont++;
                            newStack.add(numbersToMerge.get(i+1).get(0));
                            numbersToMerge.get(i+1).remove(0);
                            cont++;
                        }
                    } else {
                        break;
                    }
                }
                if (numbersToMerge.get(i).size() != 0) {
                    newStack.addAll(numbersToMerge.get(i));
                } else {
                    newStack.addAll(numbersToMerge.get(i+1));
                }
            } else {
                newStack = numbersToMerge.get(i);
            }
            stacks.add(newStack);
            newStack = new Stack<>();
            cont = 0;
        }
        return stacks;
    }

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
