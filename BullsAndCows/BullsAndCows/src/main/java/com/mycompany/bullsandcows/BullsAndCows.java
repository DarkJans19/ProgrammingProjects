/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bullsandcows;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Jan Sanchez
 */
public class BullsAndCows {
    
    // This is the principal menu and shows the options of the game
    public static byte PrincipalMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tBulls and Cows");
        System.out.println("\t1. Tutorial.");
        System.out.println("\t2. Player vs Machine.");
        System.out.println("\t3. Machine vs Player.");
        System.out.println("\t4. Player vs Player.");
        System.out.println("\t5. Leave.");
        byte opc = sc.nextByte();
        return opc;
    }
    
    // This is a menu that shows if want to play with repeated numbers or not
    public static byte MenuOfRepeated(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tHow do you want to play?");
        System.out.println("\t1. With repeated numbers");
        System.out.println("\t2. Without repeated numbers");
        System.out.println("\t3. Leave.");
        byte option = sc.nextByte();
        return option;
    } 
    
    public static byte menuOfHelps(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tHow do you want to play?");
        System.out.println("\t1. With helps");
        System.out.println("\t2. Without helps");
        System.out.println("\t3. Leave.");
        byte optionHelps = sc.nextByte();
        return optionHelps;
    }
    
    public static void tutorialMessage(){
        System.out.println("Welcome to the tutorial of the game bulls and cows, this is an interesting game and");
        System.out.println("the objective of the game is to guess a number, and the machine will give you some");
        System.out.println("clues to guess it, named bulls and cows");
        System.out.println("The bulls are the correct number in the correct position");
        System.out.println("The cows are the correct number but not the correct position");
        System.out.println("Give it a try");
    }
    
    /* This method allows the player to enter the amount of numbers that they want to play, and if they choose an option
    bigger than 10 or smallest than 1 enter to the iteration 
    */
    public static int numberOfDigits(){
        Scanner sc = new Scanner(System.in);        
        System.out.print("How many numbers do you want to play with?: ");
        int digits = sc.nextInt();
        while(digits < 1 || digits > 10){
            System.out.print("Write again the amount of digits do you want to play: ");
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
    
    // This method checks if the number generated is repeated or not
    public static boolean isRepeated(int[] numRandom, int generatedNumber, int i){
      for(int j = 0; j < i; j++){
        if(generatedNumber == numRandom[j]){
          return true;
        }
      }
      return false;
    }
    
    // A array with random number without repeated numbers
    public static int[] randomNumberNonRepeated(int digits){
      int[] numRandom = new int[digits];
      Random random = new Random();
      int i = 0, generatedNumber;
      while(i < digits){
        generatedNumber = random.nextInt(10);
        if(!isRepeated(numRandom, generatedNumber, i)){
          numRandom[i] = generatedNumber;
          i++;
        }
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
            System.out.print("Enter a number of " + digits + " digits: ");
            enterNumber = sc.nextLine();
        } while (enterNumber.length() != digits || !isValid(enterNumber));
        return enterNumber;
    }
    
    // Show the amount of cows of the entered number 
    public static int bulls(int[] numberArray, int[] randomArray){
        int bulls = 0;
        for(int i = 0; i < randomArray.length; i++){
            // if in the position i of the number the player entered is equal of the number in the random array is a bull
            if(numberArray[i] == randomArray[i]){
                bulls++;
            }
        }
        return bulls;
    }
    
    // Show the amount of cows of the entered number 
    public static int cows(int[] numberArray, int[] randomArray){
        int cows = 0;
        boolean marked[] = new boolean[randomArray.length];
        // same logic of the bulls but in this case mark the bulls so when we calculate the cows they dont count the bull
        for(int i = 0; i < randomArray.length; i++){
            if(numberArray[i] == randomArray[i]){
                marked[i] = true;
            }
        }
        for(int i = 0; i < randomArray.length; i++){
            // check if the position is a bull
            if(!marked[i]){    
                for(int j = 0; j < randomArray.length; j++){
                    // if in the position i of the number entered is equal of some other number of the random Array is a cow
                    // and if the number is repeated dont have any problems
                    if(numberArray[i] == randomArray[j]){
                        cows++;  
                        break;
                    }
                }
            }
        }
        return cows;
    }
    
    // Here is the option of the player to choose play with helps or not
    public static boolean wantHelp(){
        byte optionHelps;
        do{
            optionHelps = menuOfHelps();
            switch(optionHelps){
                case 1:
                    System.out.println("Game with helps");
                    return true;
                case 2:
                    System.out.println("Game without helps");
                    return false;
                case 3: 
                    System.out.println("Go back");
                    break;
                default:
                    System.out.println("Not a valid option, try again");
                    break;
            }
        }while(optionHelps != 3);
        return false;
    }
    
    // Here is the option of the player to choose play with repeated numbers or not
    public static boolean howWantPlay(){
        byte optionRepeated;
        do{
            optionRepeated = MenuOfRepeated();
            switch(optionRepeated){
                case 1:
                    System.out.println("Game with repeateds numbers");
                    return true;
                case 2:
                    System.out.println("Game without repeateds numbers");
                    return false;
                case 3: 
                    System.out.println("Go back");
                    break;
                default:
                    System.out.println("Not a valid option, try again");
                    break;
            }
        }while(optionRepeated != 3);
        return false;
    }
    
    // Finish the game of bulls and cows
    public static boolean finishGame(int bulls, int digits){
        return bulls == digits;
    }
    
    // Add the logic of the score of the game
    public static int score(int actualTries, int totalTries){
        totalTries *= 100;
        actualTries *= 100;
        int score = totalTries - actualTries;
        return score;
    }
    
    // This method shows the helps to the player after they get an especific score
    public static void helps(boolean askHelp, int totalTries, int tries, int[] randomArray, int[] numberArray, boolean [] flags){
        int score = score(tries, totalTries);
        totalTries *= 100;
        if(askHelp){
            if(!flags[0] && score <= totalTries * 0.25){
                giveHelp(randomArray, numberArray);
                flags[0] = true;
            }
            else if(!flags[1] && score <= totalTries / 2){
                giveHelp(randomArray, numberArray);
                flags[1] = true;
            }
            else if(!flags[2] && score <= totalTries * 0.75){
                giveHelp(randomArray, numberArray);
                flags[2] = true;
            }
            else if(!flags[3] && score == 100){
                giveHelp(randomArray, numberArray);
                flags[3] = true;
            }
        }
    }
    
    // Restart the boolean array for the method giveHelp
    public static void restartBooleanArrays(boolean[] Array){
        for(boolean bool : Array){
            bool = false;
        }
    }
    
    // This method shows the helps after cheking if the number entered was a bull, and show another number in the random Array
    public static void giveHelp(int[] randomArray, int[] numberArray){
        boolean[] marked = new boolean[randomArray.length];
        int i;
        for(i = 0; i < randomArray.length; i++){
            // if in the position i of the number the player entered is equal of the number in the random array is a bull
            if(numberArray[i] == randomArray[i]){
                marked[i] = true;
            }
        }
        for(int j = 0; j < randomArray.length; j++){
            if(!marked[j]){
                System.out.println("A clue of a bull is the number " + randomArray[j]);
                break;
            }
        }
        // Restart the boolean because if all hints are showed the array thinks that all possible hint were showed when not
        restartBooleanArrays(marked);
    }
    
    //Logic of the player vs machine
    public static int playerVsMachine(int digits, int tries, boolean isTutorial){
        // initialize the variables
        int actualTries = 0;
        int bulls;
        int cows;
        // Define if the game will have helps or not
        boolean askHelp = wantHelp();
        // Define if the game will have repeated or not repeated numbers 
        boolean gameWithRepeated = howWantPlay();
        // Initialize an empty random array
        int[] numRandom = new int[digits];
        // Fill the array depending if the array generated is repeated or not
        if(gameWithRepeated){
            numRandom = randomNumberNonRepeated(digits); 
        }
        else{
            numRandom = numberRandom(digits); 
        }
        // This boolean array shows the helps once and if turning true when a help is given
        boolean[] flags = {false, false, false, false};
        // if the game is the tutorial shows the menu of the tutorial and shows the random number generated
        if(isTutorial){
            System.out.println("Random number generated: ");
            showArray(numRandom);
        }
        do{
            // The player enter his number
            String numberEntered = enterNumber(digits);
            System.out.println("Number entered: ");
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
            // Show and actualize the number of tries
            System.out.println("Actual tries: " + (actualTries+1));
            // Finish the game if the player guess the number
            if(finishGame(bulls, digits)){
                System.out.println("Congratulations you guessed the number!");
                break;
            }
            // if the player wants helps give helps
            helps(askHelp, tries, actualTries, numRandom, numArray, flags);
            actualTries++;   
        }while(actualTries < tries);
        // if the player doesn't guess the number show this message
        if(!finishGame(bulls, digits)){
            System.out.println("Sorry you have run out of tries, better luck the next time!");
        }
        System.out.println("The generated number was: " + Arrays.toString(numRandom));
        System.out.println("Your score is: " + score(actualTries, tries));
        return actualTries;
    }
    
    // Método para generar un número aleatorio sin dígitos repetidos
    public static int[] numberRandomBull(int digits) {
        int[] numRandom = new int[digits];
        Random random = new Random();
        
        for (int i = 0; i < digits; i++) {
            int digit;
            do {
                digit = random.nextInt(10); // Generar un dígito aleatorio
            } while (contains(numRandom, digit)); // Asegurarse de que el dígito no se repita en esta conjetura
            numRandom[i] = digit;
        }
        
        return numRandom;
    }
    
    public static boolean contains(int[] numRandom, int digits){
        for(int num : numRandom){
            if(num == digits){
                return true;
            }
        }
        return false;
    }
        // Método para ajustar la conjetura basada en bulls y cows
    public static int[] adjustGuess(int[] guessedNumber, boolean[] digitsUsed, int bulls, int cows) {
        Random random = new Random();
        
        // Almacenar los dígitos que no son bulls
        int[] possibleCows = new int[guessedNumber.length];
        int cowIndex = 0;
        
        // Identificar los dígitos que son bulls y mantener su posición
        for (int i = 0; i < guessedNumber.length; i++) {
            if (!digitsUsed[i]) {
                possibleCows[cowIndex++] = guessedNumber[i];
            }
        }
        
        // Si hay cows, permutar sus posiciones
        if (cows > 0 && cowIndex > 0) {
            // Permutar posiciones de los posibles cows
            for (int i = 0; i < cowIndex; i++) {
                int swapIndex = random.nextInt(cowIndex);
                int temp = possibleCows[i];
                possibleCows[i] = possibleCows[swapIndex];
                possibleCows[swapIndex] = temp;
            }
            
            // Reasignar los valores permutados de cows a guessedNumber
            cowIndex = 0;
            for (int i = 0; i < guessedNumber.length; i++) {
                if (!digitsUsed[i]) {
                    guessedNumber[i] = possibleCows[cowIndex++];
                }
            }
        }
        
        // Marcar bulls conocidos
        for (int i = 0; i < guessedNumber.length; i++) {
            if (!digitsUsed[i] && bulls > 0) {
                digitsUsed[i] = true;
                bulls--;
            }
        }
        
        return guessedNumber;
    }
    
    public static void machineVsPlayer(int digits, int tries){
        // initialize the variables
        int actualTries = 0;
        int bulls = 0;
        int cows;
        int[] guessedNumber;
        int[] knownBulls = new int[digits];
        boolean[] digitsUsed = new boolean[10];
        Scanner sc = new Scanner(System.in);
        while(actualTries < tries){
            guessedNumber = numberRandomBull(digits);
            System.out.println("Machine guesses: ");
            showArray(guessedNumber);
            System.out.println("Number of Bulls: ");
            bulls = sc.nextInt();
            System.out.println("Number of cows: ");
            cows = sc.nextInt();
            if(finishGame(bulls, digits)){
                System.out.println("The machine guessed the number!");
                break;
            }   
            guessedNumber = adjustGuess(guessedNumber, digitsUsed, bulls, cows);
            Arrays.fill(digitsUsed, false);
            System.out.println("Number of tries: " + (actualTries + 1));
            actualTries++;
        }
        if(!finishGame(bulls, digits))
        System.out.println("The machine can't guess the number");
    }
    
    public static void playerVsPlayer(int digits, int tries){
        System.out.println("First player turn");
        int player1 = playerVsMachine(digits, tries, false);
        int score1 = score(player1, tries);
        System.out.println("Second player turn");
        int player2 = playerVsMachine(digits, tries, false);
        int score2 = score(player2, tries);
        // The number with more score wins 
        if(score1 > score2){
            System.out.println("The player 1 wins");
        }
        else if(score1 < score2){
            System.out.println("The player 2 wins");
        }
        else{
            System.out.println("Nobody's wins");
        }
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
    
    // it is the main and show the options of the game
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
                    tutorialMessage();
                    digits = numberOfDigits();
                    tries = numberOfTries(digits);
                    System.out.println("I will show you the random number so you can understand better");
                    playerVsMachine(digits, tries, true);
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
                                    playerVsMachine(digits, tries, false);
                                    break;
                                case 2:
                                    System.out.println("You chose without repeated numbers");
                                    digits = numberOfDigits();
                                    tries = numberOfTries(digits);
                                    playerVsMachine(digits, tries, false);
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
                                    digits = numberOfDigits();
                                    tries = numberOfTries(digits);
                                    machineVsPlayer(digits, tries);
                                break;
                            case 2:
                                    System.out.println("You chose without repeated numbers");
                                    digits = numberOfDigits();
                                    tries = numberOfTries(digits);
                                    machineVsPlayer(digits, tries);
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
                                digits = numberOfDigits();
                                tries = numberOfTries(digits);
                                playerVsPlayer(digits, tries);
                                break;
                            case 2:
                                System.out.println("You chose without repeated numbers");
                                digits = numberOfDigits();
                                tries = numberOfTries(digits);
                                playerVsPlayer(digits, tries);
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

