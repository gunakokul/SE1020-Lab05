import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First order
        PizzaOrder order1 = new PizzaOrder("O3001", "Olivia Green", "Medium", 3, true);
        order1.displayOrderDetails();

        // Second order with discount
        PizzaOrder order2 = new PizzaOrder("O3002", "Noah Smith", "Large", 2, false);
        order2.displayOrderDetails();
        System.out.println("Enter the discount percentage: ");
        double percentage = sc.nextDouble();
        System.out.println("Order 02 - Price after the discount: $" + order2.calculateTotalPrice(percentage));
        System.out.println();

        // Third order using default constructor
        PizzaOrder order3 = new PizzaOrder();
        order3.displayOrderDetails();

        sc.close();
    }
}
