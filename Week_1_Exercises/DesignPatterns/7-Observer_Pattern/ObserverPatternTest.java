
public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        // Initial update
        stockMarket.notifyObservers();

        System.out.println();

        // Update stock price
        stockMarket.setStockPrice(155.00);

        System.out.println();

        // Deregister an observer and update stock price
        stockMarket.deregisterObserver(mobileApp2);
        stockMarket.setStockPrice(160.00);
    }
}
