 public class ProfitCalculator {
    public static void main(String[] args) {
               double costPrice = 129.0;
        double sellingPrice = 191.0;

                double profit = sellingPrice - costPrice;
        double profitPercent = (profit / costPrice) * 100;

        System.out.println(
            "The Cost Price is INR " + costPrice + " and the Selling Price is INR " + sellingPrice + "\n" +
            "The Profit is INR " + profit + " and the Profit Percentage is " + String.format("%.2f", profitPercent) + "%"
        );
    }
}