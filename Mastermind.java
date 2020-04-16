import java.util.Arrays;
import java.util.Scanner;

public class Mastermind {

    // Little routine to ask the player to start the game
    public static void startGame() {
        System.out.println("Welcome to the Mastermind game - Are you a mastermind?");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter \"Y\" to continue. Or \"n\" to close the game.");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("")) {
            System.out.println("Another time maybe...");
            scanner.close();
            System.exit(0);
        }
        if (input.equalsIgnoreCase("Y")) {
        } else {
            System.out.println("Please input \"Y\".");
            startGame();
        }
    }

    // This method generates the color code used by the computer player,
    // where the colors are numbers in the range of 0-7
    public static int[] generatedCombination() {
        int[] combination = new int[4];
        int max = 8;
        int min = 0;

        // I know Math.random only produces pseudo random numbers
        // but for this little game it's enough I think
        for (int i = 0; i < 4; i++) {
            combination[i] = (int) (Math.random() * (max - min)) + min;
        }
        // System.out.println(Arrays.toString(combination));

        return combination;
    }

    // Get the user input numbers for the players guess
    public static int[] getUserInput(Scanner s) {
        System.out.println("Please type in your guess for this turn: ");

        // Reads each line and splits input after whitespace into the array
        String[] input = s.nextLine().split(" ");

        // Parse each input to an integer
        int numbers[] = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        // How to properly handle the scanner close ???
        // s.close();
        System.out.print("Your guess was: ");
        System.out.println(Arrays.toString(numbers));

        return numbers;
    }

    // Compare the players input to the generated combination
    // and print which color was correctly guessed
    public static void compareInputToCombination(int[] playersGuess, int[] computersCombination) {
        // System.out.println(Arrays.toString(playersGuess));
        // System.out.println(Arrays.toString(computersCombination));

        String[] guessResult = new String[4];
        int correctGuessCounter = 0;

        // Check the given Arrays on matching cases
        for (int i = 0; i < computersCombination.length; i++) {
            // If a match is found set the corresponding value
            if (playersGuess[i] == computersCombination[i]) {
                guessResult[i] = "*";
                correctGuessCounter++;
            } else {
                guessResult[i] = "#";
            }
        }

        // Check if all colors were guessed correctly and start a new game if so
        // else print out the guess result that the player can see how close he is
        if (correctGuessCounter == 4) {
            System.out.println("Guess result: " + Arrays.toString(guessResult));
            System.out.println("CONGRATULATIONS - YOU WON!");
            System.exit(0);
        } else {
            System.out.println("Guess result: " + Arrays.toString(guessResult));
        }
    }

    public static void main(String[] args) {
        // Start and ask the player if he is ready
        startGame();

        System.out.println(
                "Your turn! \nBut keep in mind the colors you can choose from are disguised under the numbers from 0 to 7. \nIt's up to your imagination which color stands behind each number.");

        // Generate the Computers color combination
        int[] combination = generatedCombination();

        // Initialization of the scanner for the user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int[] guess = getUserInput(scanner);
            compareInputToCombination(guess, combination);
        }
    }
}