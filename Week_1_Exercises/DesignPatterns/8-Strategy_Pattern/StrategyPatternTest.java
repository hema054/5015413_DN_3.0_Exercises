
public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create PaymentStrategy objects
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");

        // Create PaymentContext with CreditCardPayment strategy
        PaymentContext paymentContext = new PaymentContext(creditCard);
        paymentContext.executePayment(150.00);

        System.out.println();

        // Change PaymentStrategy to PayPalPayment
        paymentContext = new PaymentContext(payPal);
        paymentContext.executePayment(200.00);
    }
}
