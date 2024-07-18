/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bullsandcows;

import java.util.Random;
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
    
    public static int[] numberRandom(int digits) {
        int[] numRandom = new int[digits];
        Random random = new Random();

        for (int i = 0; i < digits; i++) {
            numRandom[i] = random.nextInt(10);
        }

        return numRandom;
    }

    public static int enterNumber(Scanner sc, int digits) {
        int enterNumber;
        do {
            System.out.print("\tEnter a number of " + digits + ": ");
            enterNumber = sc.nextInt();
        } while (countDigits(enterNumber) != digits);

        return enterNumber;
    }

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }
    
    public static void IterationOfRepeated(){
        int option;
        int amountOfDigits;
        int amountOfTries;
        do{
            option = MenuOfRepeated();
            if(option == 1 || option == 2){
                amountOfDigits = numberOfDigits();
                amountOfTries = numberOfTries(amountOfDigits);
            }
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
        
        Scanner sc = new Scanner(System.in);   
        int digits = numberOfDigits();
       
        int[] numRandom = numberRandom(digits);

        System.out.println("Random number generated: ");
        for (int num : numRandom) {
            System.out.print(num);
        }

        int numberEntered = enterNumber(sc, digits);

        System.out.print("Number entered: ");
        System.out.println(numberEntered);
    }
    /*
    
    public static void main(String[] args) {
        int opc;
        do{
            opc = PrincipalMenu();
            switch(opc){
                case 1:
                    System.out.println("Tutorial");
                    break;
                case 2:
                    System.out.println("Player vs Machine");
                    IterationOfRepeated();
                    break;
                case 3:
                    System.out.println("Machine vs Player");
                    IterationOfRepeated();
                    break;
                case 4:
                    System.out.println("Player vs Player");
                    IterationOfRepeated();
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
    */
}

