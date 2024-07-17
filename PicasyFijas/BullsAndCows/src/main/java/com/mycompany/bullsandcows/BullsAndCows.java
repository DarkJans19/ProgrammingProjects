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
    public static int numberOfDigits(){
        Scanner entrada = new Scanner(System.in);        
        System.out.println("¿Con cuantos digitos desea jugar?");
        int digitos = entrada.nextInt();
        while(digitos < 1 || digitos > 10){
            System.out.println("Vuelva a escribir la cantidad de digitos");
            digitos = entrada.nextInt();
        }
        System.out.println("la cantidad de digitos a jugar es: " + digitos);
        return digitos;
    }
    public static int numberOfTries(int digitos){
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Cuantos intentos quiere realizar?: ");
        int intentos = entrada.nextInt();
        while(intentos <= 0 || intentos > (digitos * 5)){
            System.out.println("Vuelva a escribir la cantidad de intentos");
            intentos = entrada.nextInt();
        }   
        System.out.println("La cantidad de intentos a jugar es: " + intentos);
        return intentos;
    }
    public static void main(String[] args) {
        int cantidadDigitos = numberOfDigits();
        int cantidadIntentos = numberOfTries(cantidadDigitos);
    }
}

