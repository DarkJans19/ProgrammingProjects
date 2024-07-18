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
        System.out.print("How many numbers do you want to play with?");
        int digits = sc.nextInt();
        while(digits < 1 || digits > 10){
            System.out.print("Write again the amount of digits do you want to play");
            digits = sc.nextInt();
        }
        System.out.println("The amount of digits to play is: " + digits);
        return digits;
    }
    
    public static int numberOfTries(int digits){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many tries do you want to play with?: ");
        int tries = sc.nextInt();
        while(tries <= 0 || tries > (digits * 5)){
            System.out.print("Write again the number of tries");
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
    
    public static String optionsMain(int opc){
        return switch (opc) {
            case 2 -> "Player vs Machine";
            case 3 -> "Machine vs Player";
            case 4 -> "Player vs Player";
            default -> "";
        };
    }
    public static String optionsRepeatedNumbers(int opc){
        return switch (opc) {
            case 1 -> "You chose repeated numbers";
            case 2 -> "You chose without repeated numbers";
            default -> "";
        };
    }
    
    public static int[] numberRandom(int digits) {
        int[] numRandom = new int[digits];
        Random random = new Random();

        for (int i = 0; i < digits; i++) {
            numRandom[i] = random.nextInt(10);
        }

        return numRandom;
    }

    public static int enterNumber(int digits) {
        Scanner sc = new Scanner(System.in);
        int enterNumber;
        do {
            System.out.print("\nEnter a number of " + digits + " digits: ");
            enterNumber = sc.nextInt();
        } while (countDigits(enterNumber) != digits);

        return enterNumber;
    }

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }
    
    public static void IterationOfRepeated(){
        int option;
        int digits;
        int tries;
        do{
            option = MenuOfRepeated();
            switch(option){
                case 1:
                case 2:
                    System.out.println(optionsRepeatedNumbers(option));
                    digits = numberOfDigits();
                    tries = numberOfTries(digits);
                    startGame(digits);
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
    
    public static void startGame(int digits){
        int[] numRandom = numberRandom(digits);
        System.out.print("Random number generated: ");  
        for (int num : numRandom) {
            System.out.print(num);
        }
        int numberEntered = enterNumber(digits);

        System.out.print("Number entered: ");
        System.out.println(numberEntered);
    }
    
    public static void main(String[] args) {
        int opc;
        do{
            opc = PrincipalMenu();
            switch(opc){
                case 1:
                    System.out.println("Tutorial");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println(optionsMain(opc));
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
}

