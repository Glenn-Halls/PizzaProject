package Pizzeria;

import java.text.NumberFormat;

public class Pizza {

    public static final float
            SMALL_BASE_PRICE = 8.0F,
            LARGE_BASE_PRICE = 11.0F,
            FAMILY_BASE_PRICE = 14.0F,
            SMALL_TOPPING_PRICE = 1.0F,
            LARGE_TOPPING_PRICE = 1.5F,
            FAMILY_TOPPING_PRICE = 2.0F;

    enum PizzaSize {SMALL, LARGE, FAMILY, UNKNOWN}

    private PizzaSize baseSize;
    private int numToppings;
    private int quantity;

    public Pizza (char base, int toppings, int num) {
        setBaseSize(switch (base) {
            case 's' -> PizzaSize.SMALL;
            case 'l' -> PizzaSize.LARGE;
            case 'f' -> PizzaSize.FAMILY;
            default -> PizzaSize.UNKNOWN;
        });
        setNumToppings(toppings);
        setQuantity(num);
    }

    public Pizza() {
        setBaseSize(PizzaSize.SMALL);
        setNumToppings(1);
        setQuantity(1);
    }

    public String getBaseSize() {return baseSize.toString();}
    public int getNumToppings() {return numToppings;}
    public int getQuantity() {return quantity;}

    public void setBaseSize(PizzaSize baseSize) {this.baseSize = baseSize;}
    public void setNumToppings(int numToppings) {this.numToppings = numToppings;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public double calculateCost() {
        PizzaSize base = this.baseSize;
        double basePrice = switch (base) {
            case SMALL -> SMALL_BASE_PRICE;
            case LARGE -> LARGE_BASE_PRICE;
            case FAMILY -> FAMILY_BASE_PRICE;
            default -> 0;
        };
        double toppingPrice = switch (base) {
            case SMALL -> SMALL_TOPPING_PRICE;
            case LARGE -> LARGE_TOPPING_PRICE;
            case FAMILY -> FAMILY_TOPPING_PRICE;
            default -> 0;
        };
        return (quantity * (basePrice + (toppingPrice * numToppings)));
    }

    public String calculateCostString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(calculateCost());
    }

    public String toString() {
        String message = "";
        message += "Pizza Size: " + getBaseSize();
        message += ", number of toppings: " + getNumToppings();
        message += ", quantity ordered: " + getQuantity();
        return message;
    }
}
