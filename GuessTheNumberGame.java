import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int startRange = 1;
        int endRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        while (true) {
            rounds++;
            int secretNumber = random.nextInt(endRange - startRange + 1) + startRange;
            System.out.println("\nRound " + rounds);
            System.out.println("Guess the number between " + startRange + " and " + endRange + ".");
            int attempts = 0;

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in "
                            + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("\nGame Over! The number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("\nYour final score: " + score + " rounds won.");
                break;
            }
        }

        scanner.close();
    }
}