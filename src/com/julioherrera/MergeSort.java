package com.julioherrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeSort implements Sort {

    public MergeSort() {}

    @Override
    public Stack<Number> sort(Stack<Number> numbersToOrder) {
        //dividir todos los number de stack de una vez
        ArrayList<Stack<Number>> stacks = new ArrayList<Stack<Number>>();
        for (int i = 0; i < numbersToOrder.size(); i++) {
            Stack<Number> newStack = new Stack<Number>();
            newStack.add(numbersToOrder.get(i));
            stacks.add(newStack);
        }
        while (stacks.size() > 1) {
            stacks = merge(stacks);
        }
        return stacks.get(0);
    }

    private ArrayList<Stack<Number>> merge(ArrayList<Stack<Number>> numbersToMerge) {
        ArrayList<Stack<Number>> stacks = new ArrayList<Stack<Number>>();
        Stack<Number> newStack = new Stack<Number>();
        int total = 0;
        int cont = 0;
        for (int i = 0; i < numbersToMerge.size(); i += 2) {
            if (i < (numbersToMerge.size() - 1)) {
                total = numbersToMerge.get(i).size() + numbersToMerge.get(i + 1).size();
                while (cont < (total - 1)) {
                    if ((total - cont) == numbersToMerge.get(i).size() || (total - cont) == numbersToMerge.get(i+1).size()) {
                        if (numbersToMerge.get(i).get(0).compareTo(numbersToMerge.get(i + 1).get(0)) == 1) {
                            newStack.add(numbersToMerge.get(i + 1).get(0));
                            numbersToMerge.get(i + 1).remove(0);
                            cont++;
                        } else if (numbersToMerge.get(i).get(0).compareTo(numbersToMerge.get(i + 1).get(0)) == -1) {
                            newStack.add(numbersToMerge.get(i).get(0));
                            numbersToMerge.get(i).remove(0);
                            cont++;
                        } else {
                            newStack.add(numbersToMerge.get(i).get(0));
                            newStack.add(numbersToMerge.get(i + 1).get(0));
                            numbersToMerge.get(i).remove(0);
                            numbersToMerge.get(i + 1).remove(0);
                            cont += 2;
                        }
                    } else {
                        if (numbersToMerge.get(i).size() != 0) {
                            newStack.addAll(numbersToMerge.get(i));
                        } else {
                            newStack.addAll(numbersToMerge.get(i+1));
                        }
                    }
                }
                if (numbersToMerge.get(i).size() > numbersToMerge.get(i+1).size()) {
                    newStack.add(numbersToMerge.get(i).get(0));
                } else if (numbersToMerge.get(i).size() < numbersToMerge.get(i+1).size()) {
                    newStack.add(numbersToMerge.get(i + 1).get(0));
                }
            } else {
                newStack = numbersToMerge.get(i);
            }
            stacks.add(newStack);
            newStack = new Stack<Number>();
            cont = 0;
        }
        return stacks;
    }
}
