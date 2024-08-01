package CTS_Weekly_Exercies.Week1_DSA.Sorting_Customers_orders;

public class Main {
    public static void main(String[] args) {
        Order[] orders = new Order[] {
            new Order(1, "John", 100.0),
            new Order(2, "Priya", 50.0),
            new Order(3, "Bob", 200.0),
            new Order(4, "Alice", 150.0),
            new Order(5, "Karthik", 80.0)
        };

        System.out.println("(initial)Original Orders:");
        printOrders(orders);

        BubbleSort.sort(orders);
        System.out.println("Bubble Sort:");
        printOrders(orders);

        orders = new Order[] {
            new Order(1, "John", 100.0),
            new Order(2, "Priya", 50.0),
            new Order(3, "Bob", 200.0),
            new Order(4, "Alice", 150.0),
            new Order(5, "Karthik", 80.0)
        };

        QuickSort.sort(orders);
        System.out.println("Quick Sort:");
        printOrders(orders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }
        System.out.println();
    }
}