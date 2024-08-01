package CTS_Weekly_Exercies.Week1_DSA.Financial_Forecasting;

public class Main {
    public static void main(String[] args) {
        double presentValue = 1000.0; // initial investment
        double growthRate = 0.05; // 5% growth rate
        int periods = 5; // 5 years

        double futureValue = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
