import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

// Begin PizzaOrder.java
// Represents a pizza order (bases and toppings) and the costs.
public class PizzaOrder {
    // Costs of pizza bases and toppings.
    public static final double SMALL_BASE_PRICE = 8.0;
    public static final double LARGE_BASE_PRICE = 11.0;
    public static final double FAMILY_BASE_PRICE = 14.0;
    public static final double SMALL_TOPPING_PRICE = 1.0;
    public static final double LARGE_TOPPING_PRICE = 1.5;
    public static final double FAMILY_TOPPING_PRICE = 2.0;
    private static int line3;

    // Calculates the cost of a fixed pizza order.
    public static void main(String[] args) {
        Random rng = new Random();

        // Read File
        int line1 = 0;
        int line2 = 0;
        try {
            File order = new File("order.txt");
            if (!order.isFile()) {
                System.out.println("Error, file does not exist");
                System.exit(3);
            }
            Scanner textReader = new Scanner(new FileInputStream("order.txt"));
            try {
                line1 = Integer.parseInt(textReader.nextLine());
                line2 = Integer.parseInt(textReader.nextLine());
                line3 = Integer.parseInt(textReader.nextLine());
            } catch (Exception nlf) {
                System.out.println("Error: no line found");
                System.exit(4);
            } finally {
                textReader.close();
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("I'm sorry, that file does not exist");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("I'm sorry, an error occurred");
            System.out.println(2);
        }

// Order details. Adjust according to the order.
        int numSmallPizzas = line1;
        int numLargePizzas = line2;
        int numFamilyPizzas = line3;
        int numSmallToppings = rng.nextInt(6) + 1;
        int numLargeToppings = rng.nextInt(6) + 1;
        int numFamilyToppings = rng.nextInt(6) + 1;
// Storing costs.
        double smallCost = 0.0;
        double largeCost = 0.0;
        double familyCost = 0.0;
        double totalCost = 0.0;
// Cost for small pizzas.
        System.out.print("Order for small pizzas: $");
        smallCost = (SMALL_BASE_PRICE + (numSmallToppings *
                SMALL_TOPPING_PRICE)) * numSmallPizzas;
        System.out.println(smallCost);
        totalCost += smallCost;
// Cost for large pizzas.
        System.out.print("Order for large pizzas: $");
        largeCost = (LARGE_BASE_PRICE + (numLargeToppings *
                LARGE_TOPPING_PRICE)) * numLargePizzas;
        System.out.println(largeCost);
        totalCost += largeCost;
// Cost for family pizzas.
        System.out.print("Order for family pizzas: $");
        familyCost = (FAMILY_BASE_PRICE + (numFamilyToppings *
                FAMILY_TOPPING_PRICE)) * numFamilyPizzas;
        System.out.println(familyCost);
        totalCost += familyCost;
// Overall cost.
        System.out.print("Total cost is: $");
        System.out.println(totalCost);

        File menu = new File("menu.txt");
        if (menu.isFile()) {
            try {
                Scanner text = new Scanner(menu);
                while (text.hasNextLine()) {
                    String line = text.nextLine();
                    if (line.toLowerCase().contains("chicken")) {
                        System.out.print("HOT ");
                    }
                    System.out.println(line);

                }
                text.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("Error");
            }


        } else {
            System.out.println("no such file exists");
            System.exit(5);
        }
    }
}

