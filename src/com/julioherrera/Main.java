package com.julioherrera;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Sorting Program
 *
 * @author <Authors name>
 * @since <pre>feb. 16, 2020</pre>
 * @version 1.0
 */

public class Main {

    private static int sizeArray;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean finished = false;
        int userSelection;
        int orderSelection;
        //Opciones de inicio
        System.out.println("Escriba cuantos numeros va a ordenar");
        sizeArray = scan.nextInt();
        scan.nextLine();
        generateRandomNumbers();
        generateOrderedNumbers();
        Comparable[] numeros = new Comparable[sizeArray];
        //Ciclo para mostrar el menu del programa
        while(!finished) {
            userSelection = showMenu();
            switch(userSelection) {
                case 1:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                    }
                    SelectionSort selectionSort = new SelectionSort();
                    imprimirNumeros(numeros);
                    numeros = selectionSort.sort(numeros);
                    imprimirNumeros(numeros);
                break;
                case 2:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                    }
                    MergeSort mergeSort = new MergeSort();
                    imprimirNumeros(numeros);
                    numeros = mergeSort.sort(numeros);
                    imprimirNumeros(numeros);
                break;
                case 3:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                    }
                    QuickSort quickSort = new QuickSort();
                    imprimirNumeros(numeros);
                    numeros = quickSort.sort(numeros);
                    imprimirNumeros(numeros);
                break;
                case 4:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                    }
                    RadixSort radixSort = new RadixSort();
                    imprimirNumeros(numeros);
                    numeros = intToComparable(radixSort.sort(comparableToInt(numeros)));
                    imprimirNumeros(numeros);
                break;
                case 5:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                    }
                    BubbleSort bubbleSort = new BubbleSort();
                    imprimirNumeros(numeros);
                    numeros = bubbleSort.sort(numeros);
                    imprimirNumeros(numeros);
                break;
            }
        }
    }

    private static int showMenu() {
        System.out.println("------------METODOS DE SORTING----------------");
        System.out.println("1. Selection sort");
        System.out.println("2. Merge sort");
        System.out.println("3. Quick sort");
        System.out.println("4. Radix sort");
        System.out.println("5. Bubble sort");
        Scanner scan = new Scanner(System.in);
        int userSelection = scan.nextInt();
        scan.nextLine();
        return userSelection;
    }

    //Ayudita de Exon Fernando: http://decodigo.com/java-crear-archivos-de-texto
    private static void generateRandomNumbers() throws IOException {
        String numbers = "";
        for (int i = 0; i < sizeArray; i++) {
            numbers += String.valueOf((int) (Math.random() * (sizeArray * 2)) - sizeArray) + "\n";
        }
        String ruta = "numerosAleatoreos.txt";
        File file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(numbers);
        bufferedWriter.close();
    }

    //Extraido de: http://decodigo.com/java-leer-un-archivo-de-texto
    private static void generateOrderedNumbers() throws IOException {
        String numbers = "";
        for (int i = 0; i < sizeArray; i++) {
            numbers += String.valueOf(i) + "\n";
        }
        String ruta = "numerosOrdenados.txt";
        File file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(numbers);
        bufferedWriter.close();
    }


    //inspirado de http://decodigo.com/java-leer-un-archivo-de-texto
    private static Comparable[] readFile(boolean ordered) throws FileNotFoundException {
        Scanner entrada;
        Comparable[] numeros = new Comparable[sizeArray];
        if (ordered) {
            entrada = new Scanner(new File("numerosOrdenados.txt"));
        } else {
            entrada = new Scanner(new File("numerosAleatoreos.txt"));
        }
        int cont = 0;
        while(entrada.hasNextLine()) {
            numeros[cont] = Integer.parseInt(entrada.nextLine());
            cont++;
        }
        entrada.close();
        return numeros;
    }

    //Solo para imprimir los numeros y ver si se ordenaron
    private static void imprimirNumeros(Comparable[] list) {
        System.out.println("----------------Numeros-----------------");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    //Se han realizado estos metodos para el RadixSort, ya que este no acepta Comparable[] en si
    //Y para no cargarle procesos a la clase de RadixSort se han realizado aca
    //Asi el profiler puede verificar bien la cantidad de CPU que consumio solo el ordenar
    //Y no convertir la lista tambien
    private static int[] comparableToInt(Comparable[] comparables) {
        int[] ints = new int[comparables.length];
        for (int i = 0; i < comparables.length; i++) {
            ints[i] = (int) comparables[i];
        }
        return ints;
    }
    private static Comparable[] intToComparable(int[] ints) {
        Comparable[] comparables = new Comparable[ints.length];
        for (int i = 0; i < ints.length; i++) {
            comparables[i] = ints[i];
        }
        return comparables;
    }
}
