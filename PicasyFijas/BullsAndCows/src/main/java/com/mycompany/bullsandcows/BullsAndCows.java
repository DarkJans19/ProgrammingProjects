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
    
    // This is the principal menu and shows the options of the game
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
    
    // This is a menu that shows if want to play with repeated numbers or not
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
    
    /* This method allows the player to enter the amount of numbers that they want to play, and if they choose an option
    bigger than 10 or smallest than 1 enter to the iteration 
    */
    public static int numberOfDigits(){
        Scanner sc = new Scanner(System.in);        
        System.out.print("How many numbers do you want to play with?: ");
        int digits = sc.nextInt();
        while(digits < 1 || digits > 10){
            System.out.print("Write again the amount of digits do you want to play");
            digits = sc.nextInt();
        }
        System.out.println("The amount of digits to play is: " + digits);
        return digits;
    }
    
    /* This method allows the player to enter the amount of tries that they want to play, and if they choose an option
    bigger than the (amount of digits * 5) or smallest than 1 enter to the iteration 
    */
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
    
    
    // This method generate an array with randoms numbers 
    public static int[] numberRandom(int digits) {
        int[] numRandom = new int[digits];
        Random random = new Random();
        for (int i = 0; i < digits; i++) {
            numRandom[i] = random.nextInt(10);
        }
        return numRandom;
    }
        // Use the generated String to save the chars into an array
    public static char[] generateArray(String newNumber){
        char[] numberArray = newNumber.toCharArray();
        return numberArray;
    }
    
    // Convert a char array to an int
    public static int[] charToString(char[] numberArray){
        int newNumber[] = new int[numberArray.length];
        for (int i = 0; i < numberArray.length; i++){
            newNumber[i] = numberArray[i] - '0';
        }
        return newNumber;
    }
    
    // Show the array generated
    public static void showArray(int[] numberArray){
        for(int number : numberArray){
            System.out.print(number + " ");
        }
        System.out.println();
    }
    // This method verifys the number has letters or not, if they have letters, or are empty or have a space return a false else return a true
    public static boolean isValid(String numEntered){
        if(numEntered == null || numEntered.isEmpty()){
            return false;
        }
        for(char digits : numEntered.toCharArray()){
            if(!Character.isDigit(digits)){
                return false;
            }
        }
        return true;
    }
    
    /* This method checkout the amount of digits the player and if is different that the amount of digits of the random number ask
    again for another number that completes the condition and return the number */
    public static String enterNumber(int digits) {
        Scanner sc = new Scanner(System.in);
        String enterNumber;
        do {
            System.out.print("\nEnter a number of " + digits + " digits: ");
            enterNumber = sc.nextLine();
        } while (enterNumber.length() != digits || !isValid(enterNumber));

        return enterNumber;
    }
    
    public static int bulls(int[] numberArray, int[] randomArray){
        int bulls = 0;
        for(int i = 0; i < randomArray.length; i++){
            if(numberArray[i] == randomArray[i]){
                bulls++;
            }
        }
        return bulls;
    }
    // Show the amount of bulls and cows of the entered number 
    public static int cows(int[] numberArray, int[] randomArray){
        int cows = 0;
        boolean marked[] = new boolean[randomArray.length];
        for(int i = 0; i < randomArray.length; i++){
            if(numberArray[i] == randomArray[i]){
                marked[i] = true;
            }
        }
        for(int i = 0; i < randomArray.length; i++){
            if(!marked[i]){    
                for(int j = 0; j < randomArray.length; j++){
                    if(numberArray[i] == randomArray[j]){
                        cows++;  
                        break;
                    }
                }
            }
        }
        return cows;
    }
    
    //Logic of the player vs machine
    public static void playerVsMachine(int digits, int tries){
        // initialize the variables
        int actualTries = 0;
        int bulls;
        int cows;
        int[] numRandom = numberRandom(digits);
        // Show the number generated
        System.out.print("Random number generated: ");      
        showArray(numRandom);
        do{
            // The player enter his number
            String numberEntered = enterNumber(digits);
            System.out.print("Number entered: ");
            // The number is transformed to char and int and save the number in an array
            char stringArray[] = generateArray(numberEntered);
            int numArray[] = charToString(stringArray);
            // Show the number array
            showArray(numArray);
            // Save in variables the amount of bulls and cows
            bulls = bulls(numArray, numRandom);
            cows = cows(numArray, numRandom);
            // Show the amount of bulls and cows
            System.out.println("The amount of bulls is: " + bulls);
            System.out.println("The amount of cows is: " + cows);
            // Finish the game if the player guess the number
            if(finishGame(bulls, numRandom)){
                System.out.println("Congratulations you guessed the number!");
                break;
            }
            // Show and actualize the number of tries
            System.out.println("Actual tries: " + (actualTries+1));
            actualTries++;
        }while(actualTries < tries);
        // if the player doesn't guess the number show this message
        if(!finishGame(bulls, numRandom)){
            System.out.println("Sorry you have run out of tries, better luck the next time!");
        }
    }
    
    public static boolean finishGame(int bulls, int[] randomArray){
        return bulls == randomArray.length;
    }
    
    // Are the options for the players if want to play with repeated numbers or not
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
    
    
    // it is the main and show the option of the game
    public static void main(String[] args) {
        int opc;
        int digits;
        int tries;
        do{
            opc = PrincipalMenu();
            int option;
            switch(opc){
                case 1:
                    System.out.println("Tutorial");
                    break;
                case 2:
                    System.out.println("Player vs Machine");
                    do{
                        option = MenuOfRepeated();
                            switch(option){
                                case 1:
                                System.out.println("You chose repeated numbers");
                                    digits = numberOfDigits();
                                    tries = numberOfTries(digits);
                                    playerVsMachine(digits, tries);
                                    break;
                                case 2:
                                    digits = numberOfDigits();
                                    tries = numberOfTries(digits);
                                    playerVsMachine(digits, tries);
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
                    break;
                case 3:
                    System.out.println("Machine vs Player");
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
                    break;
                case 4:
                    System.out.println("Player vs Player");
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

