/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bullsandcows;

import java.util.Scanner;

/**
 *
 * @author Jan Sanchez
 */
public class BullsAndCows {
    public static int numberOfTries(int intentos, int digitos){
        Scanner entrada = new Scanner(System.in);
        while(intentos <= 0 || intentos > (digitos * 5)){
            System.out.println("Vuelva a escribir la cantidad de intentos");
            intentos = entrada.nextInt();
        }
        return intentos;
    }
    public static int numberOfDigits(int digitos){
        Scanner entrada = new Scanner(System.in);
        while(digitos < 1 || digitos > 10){
            System.out.println("Vuelva a escribir la cantidad de digitos");
            digitos = entrada.nextInt();
        }
        return digitos;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Con cuantos digitos desea jugar?");
        int digitos = entrada.nextInt();
        int cantidadDigitos = numberOfDigits(digitos);
        System.out.println("¿Cuantos intentos quiere realizar?: ");
        int intentos = entrada.nextInt();
        int cantidadIntentos = numberOfTries(intentos, cantidadDigitos); 
        System.out.println("La cantidad de intentos escogidas es: " +  cantidadIntentos);
    }
}

