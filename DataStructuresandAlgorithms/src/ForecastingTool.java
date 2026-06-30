public class ForecastingTool {

    /**
     * Recursive method to calculate future value.
     * * Formula: FV = CurrentValue * (1 + growthRate)
     * * @param currentValue The principal or value at the current year
     * @param growthRate   The annual growth rate (e.g., 0.05 for 5%)
     * @param years        The number of years remaining to forecast
     * @return The projected future value
     */
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        // 1. Base Case: If no years are left, the future value is the current value.
        if (years <= 0) {
            return currentValue;
        }
        
        // 2. Recursive Step: Calculate next year's value and decrement the remaining years
        double nextYearValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextYearValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0; // $10,000 principal
        double annualGrowthRate = 0.07;     // 7% constant CAGR
        int forecastPeriodInYears = 10;     // Lookahead window

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.printf("Initial Principal: $%,.2f%n", initialInvestment);
        System.out.printf("Assumed Growth Rate: %.1f%%%n", (annualGrowthRate * 100));
        System.out.println("Forecast Period: " + forecastPeriodInYears + " years");
        
        // Execute calculation
        double finalForecast = calculateFutureValue(initialInvestment, annualGrowthRate, forecastPeriodInYears);
        
        System.out.println("---------------------------------");
        System.out.printf("Projected Future Value: $%,.2f%n", finalForecast);
    }
}