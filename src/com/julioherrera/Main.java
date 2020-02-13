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

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean finished = false;
        Stack<Number> numeros;
        int userSelection;
        int orderSelection;
        //Ciclo para mostrar el menu del programa
        while(!finished) {
            userSelection = showMenu();
            switch(userSelection) {
                case 1:
                    generateRandomNumbers();
                break;
                case 2:
                    generateOrderedNumbers();
                break;
                case 3:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    SelectionSort selectionSort = new SelectionSort();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                        selectionSort.sort(numeros);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                        selectionSort.sort(numeros);
                    }
                break;
                case 4:
                    System.out.println("Desea usar:\n1. Aleatoreos\n2. Ordenados");
                    orderSelection = scan.nextInt();
                    scan.nextLine();
                    MergeSort mergeSort = new MergeSort();
                    if (orderSelection == 1) {
                        numeros = readFile(false);
                        imprimirNumeros(numeros);
                        numeros = mergeSort.sort(numeros);
                        imprimirNumeros(numeros);
                    } else if (orderSelection == 2) {
                        numeros = readFile(true);
                        mergeSort.sort(numeros);
                    }
                break;
                case 5:

                break;
                case 6:

                break;
                case 7:

                break;
            }
        }
    }

    private static int showMenu() {
        System.out.println("------------METODOS DE SORTING----------------");
        System.out.println("1. Generar archivo de n numeros aleatoreos");
        System.out.println("2. Generar archivo de n numeros ordenados");
        System.out.println("3. Selection sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Quick sort");
        System.out.println("6. Radix sort");
        System.out.println("7. Bubble sort");
        Scanner scan = new Scanner(System.in);
        int userSelection = scan.nextInt();
        scan.nextLine();
        return userSelection;
    }

    //Ayudita de Exon Fernando: http://decodigo.com/java-crear-archivos-de-texto
    private static void generateRandomNumbers() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros que tendra la lista");
        int sizeArray = scan.nextInt();
        scan.nextLine();
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros que tendra la lista");
        int sizeArray = scan.nextInt();
        scan.nextLine();
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

    private static Stack<Number> readFile(boolean ordered) throws FileNotFoundException { //Se determino que Stack era el tipo de lista mas apropiada para ordenar
        Scanner entrada;
        Stack<Number> numeros = new Stack<Number>();
        if (ordered) {
            entrada = new Scanner(new File("numerosOrdenados.txt"));
        } else {
            entrada = new Scanner(new File("numerosAleatoreos.txt"));
        }
        while(entrada.hasNextLine()) {
            numeros.add(Number.parseNumber(entrada.nextLine()));
        }
        entrada.close();
        return numeros;
    }

    //Solo para imprimir los numeros y ver si se ordenaron
    private static void imprimirNumeros(Stack<Number> numbers) {
        System.out.println("----------------Numeros-----------------");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i).getValue());
        }
    }
}
