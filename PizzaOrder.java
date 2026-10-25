public class PizzaOrder {

    // (a) Attributes
    private String orderID;
    private String customerName;
    private String size;
    private int toppingCount;
    private boolean isDelivery;

    // (b) Default constructor
    public PizzaOrder() {
        this.orderID = "N/A";
        this.customerName = "Unknown";
        this.size = "Small";
        this.toppingCount = 0;
        this.isDelivery = false;
    }

    // (c-i) Constructor with orderID and customerName
    public PizzaOrder(String orderID, String customerName) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.size = "Small";
        this.toppingCount = 0;
        this.isDelivery = false;
    }

    // (c-ii) Constructor with all five attributes
    public PizzaOrder(String orderID, String customerName, String size,
                      int toppingCount, boolean isDelivery) {
        this.orderID = orderID;
        this.customerName = customerName;
        setSize(size); // validation applied
        this.toppingCount = toppingCount;
        this.isDelivery = isDelivery;
    }

    // (d) Getter and setter for size
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size != null && (size.equals("Small") || size.equals("Medium") || size.equals("Large"))) {
            this.size = size;
        } else {
            this.size = "Small"; // default for invalid size
        }
    }

    // (e) Base price according to size
    public double getBasePrice() {
        if (size.equals("Medium")) {
            return 10.00;
        } else if (size.equals("Large")) {
            return 12.00;
        } else {
            return 8.00;
        }
    }

    // (f-i) Total price: base + toppings + delivery fee
    public double calculateTotalPrice() {
        double total = getBasePrice() + (toppingCount * 1.50);
        if (isDelivery) {
            total += 5.00;
        }
        return total;
    }

    // (f-ii) Total price after discount
    public double calculateTotalPrice(double discountPercentage) {
        double total = calculateTotalPrice();
        return total - (total * discountPercentage / 100);
    }

    // (g) Estimated preparation time
    public int estimatePreparationTime() {
        return 15 + (2 * toppingCount);
    }

    // (h) Display order details
    public void displayOrderDetails() {
        System.out.println("---------- Order Details ----------");
        System.out.println("Order ID           : " + orderID);
        System.out.println("Customer Name      : " + customerName);
        System.out.println("Pizza Size         : " + size);
        System.out.println("Topping Count      : " + toppingCount);
        System.out.println("Home Delivery      : " + (isDelivery ? "Yes" : "No"));
        System.out.println("Total Price        : $" + calculateTotalPrice());
        System.out.println("Preparation Time   : " + estimatePreparationTime() + " minutes");
        System.out.println("-----------------------------------");
        System.out.println();
    }
}
