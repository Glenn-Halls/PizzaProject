import java.util.Scanner;

public class PizzaProject {

    public static final float
            SMALL_BASE_PRICE = 8.0F,
            LARGE_BASE_PRICE = 11.0F,
            FAMILY_BASE_PRICE = 14.0F,
            SMALL_TOPPING_PRICE = 1.0F,
            LARGE_TOPPING_PRICE = 1.5F,
            FAMILY_TOPPING_PRICE = 2.0F;
    public static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {

        int numToppings = 0, quantity = 0;
        double baseCost = 0, toppingCost = 0, pizzaCost = 0, totalCost = 0;
        boolean orderMore;

        do {
            char letter = inputChar("yn", "Yes or No");
            orderMore = (letter == 'y');
        } while (orderMore);

    }

    /**
     * Display a prompt to the user requesting a single character input
     * @param allowableCharacters The character/s permitted
     * @param message The message prompting user for character input
     * @return A single character from the String list of allowable characters
     */
    public static char inputChar(String allowableCharacters, String message) {
        boolean validInput;
        char charSelected = '!';
        String input;
        do {
            System.out.print(message + ": ");
            input = keyboard.nextLine();
            System.out.println();
            if (input.length() == 0) {
                validInput = false;
                System.out.println("You did not enter any characters, please try again.");
            } else if (input.length() > 1) {
                validInput = false;
                System.out.println("You entered multiple characters. Please enter a single character.");
            } else {
                if (allowableCharacters.contains(input)) {
                    validInput = true;
                    charSelected = input.charAt(0);
                } else {
                    validInput = false;
                    System.out.println("You have entered an invalid character. Please try again.");
                }
            }
        } while (!validInput);
        return charSelected;
    }

    /**
     * Prompts a user to enter an integer in a range between two numbers (inclusive).
     * @param minimum The minimum number allowed (inclusive).
     * @param maximum The maximum number allowed (inclusive).
     * @param message Message prompting user to enter an integer between minimum and maximum
     * @return Integer from the user between the minimum and maximum allowed.
     */
    public static int inputInt(int minimum, int maximum, String message) {
        String input;
        int number;
        while (true) {
            System.out.print(message + ": ");
            input = keyboard.nextLine();
            System.out.println();
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number. Please try again.");
                continue;
            }
            if (number < minimum || number > maximum) {
                System.out.printf("That is not a valid option, please choose a number between %d and %d.%n",
                        minimum, maximum);
            } else return number;
        }
    }
}
