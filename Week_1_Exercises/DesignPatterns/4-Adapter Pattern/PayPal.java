
public class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

// Stripe.java
class Stripe {
    public void executePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// Square.java
 class Square {
    public void processTransaction(double amount) {
        System.out.println("Processing payment of $" + amount + " through Square.");
    }
}
