package com.julioherrera;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean finished = false;
        //Ciclo para mostrar el menu del programa
        while(!finished) {
            showMenu();
        }
    }

    private static int showMenu() {
        System.out.println("------------METODOS DE SORTING----------------");
        System.out.println("1. Generar archivo de 3,000 numeros aleatoreos");
        System.out.println("2. ");
        Scanner scan = new Scanner(System.in);
        int userSelection = scan.nextInt();
        scan.nextLine();
        return userSelection;
    }
}
