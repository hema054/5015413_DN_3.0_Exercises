package CTS_Weekly_Exercies.Week1_DSA.Financial_Forecasting;

public class FinancialForecasting {
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case-->which helps in returning the present value, if periods is 0
    	if (periods == 0) {
            return presentValue;
        } else {
            // Recursive case-> to calculate the future value for the next period
            double nextPeriodValue = presentValue * (1 + growthRate);
            return calculateFutureValue(nextPeriodValue, growthRate, periods - 1);
        }
    }
}
