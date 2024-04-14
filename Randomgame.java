import java.util.Random;
import java.util.Scanner;

public class Randomgame {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the random number game!");

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("How many chances do you want to play this game?");
            int chances = scr.nextInt();
            int score = 0;

            for (int i = 0; i < chances; i++) {
                int randomNumber = random.nextInt(101);
                System.out.println("Enter a number between 0 to 100:");
                int guess = scr.nextInt();
                
                if (guess == randomNumber) {
                    System.out.println("Correct answer");
                    score++;
                } else if (guess > randomNumber) {
                    System.out.println("Too high");
                } else {
                    System.out.println("Too low");
                }
            }
            
            System.out.println("Game over! Your points: " + score);
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainResponse = scr.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        scr.close(); // Close the scanner when done to prevent resource leak
    }
}
