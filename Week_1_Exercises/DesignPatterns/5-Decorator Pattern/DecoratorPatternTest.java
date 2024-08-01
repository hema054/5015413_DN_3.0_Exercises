
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create an EmailNotifier
        Notifier notifier = new EmailNotifier();

        // Decorate with SMSNotifierDecorator
        notifier = new SMSNotifierDecorator(notifier);

        // Decorate with SlackNotifierDecorator
        notifier = new SlackNotifierDecorator(notifier);

        // Send a message using the decorated notifier
        notifier.send("This is a test message.");
    }
}
