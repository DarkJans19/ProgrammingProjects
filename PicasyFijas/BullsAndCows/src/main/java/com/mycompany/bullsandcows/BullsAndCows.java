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
        Scanner sc = new Scanner(System.in);        
        System.out.println("How many numbers do you want to play with?");
        int digits = sc.nextInt();
        while(digits < 1 || digits > 10){
            System.out.println("Write again the amount of digits do you want to play");
            digits = sc.nextInt();
        }
        System.out.println("The amount of digits to play is: " + digits);
        return digits;
    }
    
    public static int numberOfTries(int digits){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many tries do you want to play with?: ");
        int tries = sc.nextInt();
        while(tries <= 0 || tries > (digits * 5)){
            System.out.println("Write again the number of tries");
            tries = sc.nextInt();
        }   
        System.out.println("The amount of tries to play is: " + tries);
        return tries;
    }
    
    public static int PrincipalMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tBulls and Cows");
        System.out.println("\t1. Tutorial.");
        System.out.println("\t2. Player vs Machine.");
        System.out.println("\t3. Machine vs Player.");
        System.out.println("\t4. Player vs Player.");
        System.out.println("\t5. Leave.");
        int opc = sc.nextInt();
        return opc;
    }
    
    public static int MenuOfRepeated(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tHow do you want to play?");
        System.out.println("\t1. With repeated numbers");
        System.out.println("\t2. Without repeated numbers");
        System.out.println("\t3. Salir.");
        int option = sc.nextInt();
        return option;
    }
    public static void gameOptions(){
        int cantidadDigitos = numberOfDigits();
        int cantidadIntentos = numberOfTries(cantidadDigitos);
    }
    
    public static void IterationOfRepeated(){
        int option;
        do{
            option = MenuOfRepeated();
            switch(option){
                case 1:
                    System.out.println("You chose repeated numbers");
                    break;
                case 2:
                    System.out.println("You chose without repeated numbers");
                    break;
                case 3:
                    System.out.println("Go back");
                    break;
                default:
                    System.out.println("Not valid number, try again");
                    break;               
            }
        }while(option != 3);
    } 
    
    public static void main(String[] args) {
        int opc;
        do{
            opc = PrincipalMenu();
            switch(opc){
                case 1:
                    System.out.println("Tutorial");
                    gameOptions();
                    break;
                case 2:
                    System.out.println("Player vs Machine");
                    gameOptions();
                    IterationOfRepeated();
                    break;
                case 3:
                    System.out.println("Machine vs Player");
                    gameOptions();
                    IterationOfRepeated();
                    break;
                case 4:
                    System.out.println("Player vs Player");
                    IterationOfRepeated();
                    gameOptions();
                    break;
                case 5:
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("The number entered is not valid");
                    break;
            }
        }while(opc != 5);
    }
}

