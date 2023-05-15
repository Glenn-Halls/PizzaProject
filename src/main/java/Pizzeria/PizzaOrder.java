package Pizzeria;

import java.text.NumberFormat;
import java.util.Scanner;

public class PizzaOrder {

    static Scanner keyboard = new Scanner(System.in);
    public static final int MAX_PIZZAS = 10;


    public static Pizza[] order () {

        boolean orderMore;
        double totalCost = 0;
        NumberFormat cost = NumberFormat.getCurrencyInstance();
        int numOrders = 0;
        Pizza[] PizzaArray = new Pizza[MAX_PIZZAS];

        do {
            System.out.println("Please place an order for your pizza.");
            char sizeChar = inputChar("slf", "Size (s = small, l = large, f = family)");
            int toppings = inputInt(1, 9, "Number of toppings");
            int num = inputInt(1, 5, "Quantity");
            while ((num + Pizza.getNumPizzas()) > MAX_PIZZAS){
                System.out.println("I'm sorry, you have ordered too many pizzas, please try again.");
                num = inputInt(1,5, "Quantity");
            }
            Pizza ThisPizza = new Pizza(sizeChar, toppings, num);
            if (Pizza.getNumPizzas() < MAX_PIZZAS) {
                System.out.println("Pizza cost = " + ThisPizza.calculateCostString());
                totalCost += ThisPizza.calculateCost();
                System.out.println("Total Cost: " + cost.format(totalCost));
                char yesNo = inputChar("yn", "Order more? (y/n)");
                orderMore = (yesNo == 'y');
            } else orderMore = false;
            PizzaArray[numOrders] = ThisPizza;
        } while (orderMore && (Pizza.getNumPizzas() < MAX_PIZZAS));
        System.out.println("Thank you for you order.");
        System.out.println("Pizzas ordered: " + Pizza.getNumPizzas());
        System.out.println("Amount Due: " + cost.format(totalCost));
        return PizzaArray;
    }


        /**
         * Display a prompt to the user requesting a single character input
         * @param allowableCharacters The character/s permitted
         * @param message The message prompting user for character input
         * @return A single character from the String list of allowable characters
         */
        public static char inputChar (String allowableCharacters, String message){
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
        public static int inputInt ( int minimum, int maximum, String message){
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
