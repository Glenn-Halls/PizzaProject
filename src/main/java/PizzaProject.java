import Pizzeria.Pizza;
import Pizzeria.PizzaOrder;

public class PizzaProject {

    public static void main(String[] args) {

        Pizza[] Array = PizzaOrder.order();
        Pizza expensivePizza = null;
        double mostExpensive = 0;

        System.out.println("Your Order:");
        for (Pizza element : Array) {
            if (element != null) {
                System.out.println(element);
                if (element.calculateCost() > mostExpensive) {
                    expensivePizza = element;
                    mostExpensive = element.calculateCost();
                }
            }
        }
        if (mostExpensive > 0) {
            System.out.println("The most expensive order was:");
            try {
                System.out.println(expensivePizza);
            } catch (NullPointerException e) {
                System.out.println("Error:");
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}