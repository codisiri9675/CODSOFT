/* Create a class Game, which allows a user to play "Guess the number" game.Game
        will  have the following methods :
        1. Constructor to generate the random number
        2. takeUserInput() to take a user input of number ;
        3. isCorrectNUmber() to detect whether the number entered by user is true ;
        4. getter and setter for noOfGuesses
        Use properties such as noOfGuesses(int), etc to get this task done;

        here we guess a number between 0 to 100 then our programm will
        show entered number is greater or smaller than Guessed number

        FOR EXAMPLE : let computer generates a random number 43
        (it will be any number between 0  to 100 not necessary to be 43)and if we press 98
        then our computer will show that "you should have to enter less number" and if we
        entered 38 it will show that "enter greater number" and so on untill equal to
        guessed number*/
           
import java.util.*;
public class NumberGame {
   static Scanner sc = new Scanner(System.in);
    static int totalRounds = 0;
    static int totalWins = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!!!");
        boolean playAgain = true;

        while (playAgain) {
            playRound();
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println(" Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + totalWins);
    }

    public static void playRound() {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 7;
        boolean guessedCorrectly = false;

        totalRounds++;

        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
                totalWins++;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! please enter the high number :");
            } else {
                System.out.println(" Too high!  please enter the low number : ");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("You have used all attempts. The correct number was: " + numberToGuess);
        }
    }
}