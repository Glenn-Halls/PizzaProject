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
    // Calculates the cost of a fixed pizza order.
    public static void main(String[] args) {
// Order details. Adjust according to the order.
        int numSmallPizzas = 2;
        int numLargePizzas = 2;
        int numFamilyPizzas = 1;
        int numSmallToppings = 3;
        int numLargeToppings = 4;
        int numFamilyToppings = 6;
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
    }
}