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
    enum PizzaSize {SMALL, LARGE, FAMILY, UNKNOWN}


    public static void main(String[] args) {

        int numToppings, quantity;
        double baseCost, toppingCost, pizzaCost, totalCost = 0;
        boolean orderMore;
        PizzaSize size;


        do {
            System.out.println("Please place an order for your pizza.");
            char sizeChar = inputChar("slf", "Size (s = small, l = large, f = family)");
            size = getPizzaSize(sizeChar);
            numToppings = inputInt(1, 9, "Number of toppings");
            quantity = inputInt(1, 5, "Quantity");
            baseCost = getBaseCost(size);
            toppingCost = getToppingCost(size);
            pizzaCost = (baseCost + (toppingCost * numToppings)) * quantity;
            totalCost += pizzaCost;
            System.out.println("Pizza cost = " + pizzaCost);
            System.out.println("Total cost = " + totalCost);
            char yesNo = inputChar("yn", "Order more? (y/n)");
            orderMore = (yesNo == 'y');
        } while (orderMore);
        System.out.println("\nThank you for your order.");
        System.out.println("Payment Due: " + totalCost);

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
                if (allowableCharacters.contains(input.toLowerCase())) {
                    validInput = true;
                    charSelected = input.toLowerCase().charAt(0);
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

    public static PizzaSize getPizzaSize(char input) {
        return switch (input) {
            case 's' -> PizzaSize.SMALL;
            case 'l' -> PizzaSize.LARGE;
            case 'f' -> PizzaSize.FAMILY;
            default -> PizzaSize.UNKNOWN;
        };
    }

    public static double getBaseCost(PizzaSize size) {
        return switch (size) {
            case SMALL -> SMALL_BASE_PRICE;
            case LARGE -> LARGE_BASE_PRICE;
            case FAMILY -> FAMILY_BASE_PRICE;
            default -> 0;
        };
    }

    public static double getToppingCost(PizzaSize size) {
        return switch (size) {
            case SMALL -> SMALL_TOPPING_PRICE;
            case LARGE -> LARGE_TOPPING_PRICE;
            case FAMILY -> FAMILY_TOPPING_PRICE;
            default -> 0;
        };
    }
}
