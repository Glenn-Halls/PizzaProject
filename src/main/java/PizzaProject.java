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

        int numToppings, quantity = 0;
        double baseCost, toppingCost, pizzaCost, totalCost = 0;
        boolean orderMore = true;

        baseCost = selectBase();
        System.out.println(baseCost);

    }



    public static double selectBase() {
        boolean validOption = false;
        char selection = '!';
        double basePrice = 0;
        while (!validOption) {
            System.out.print("Size (s = small, l = large, f = family): ");
            String input = keyboard.nextLine();
            System.out.println();
            if (input.length() != 1) {
                System.out.println("Invalid Input:");
                System.out.println("Please enter a single character and press enter.");
                continue;
            } else {
                try {
                    selection = input.charAt(0);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Error, shutting down.");
                    System.exit(9);
                }
            }
            switch (selection) {
                case 'S':
                case 's':
                    validOption = true;
                    basePrice =  SMALL_BASE_PRICE;
                    break;
                case 'L':
                case 'l':
                    validOption = true;
                    basePrice = LARGE_BASE_PRICE;
                    break;
                case 'F':
                case 'f':
                    validOption = true;
                    basePrice =  FAMILY_BASE_PRICE;
                    break;
                default:
                    System.out.println("I'm sorry that is not a valid option.");
                    System.out.println("Please select from the options below");
            }
        }
        return basePrice;
    }
}
