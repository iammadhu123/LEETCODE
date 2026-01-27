public class BuyAndSellStock {
    public static int maxProfit(int prices[]){
        // int buyPrice = Integer.MAX_VALUE;
        // int maxProfit = Integer.MIN_VALUE;//or 0;
        // // int profit = 0;

        // for(int i = 0; i<prices.length; i++){
        //     if (prices[i]<buyPrice) {
        //         buyPrice = prices[i];
        //     }
        //     int profit = prices[i] - buyPrice;
        //     maxProfit = Math.max(maxProfit, profit);
        // }

        // return maxProfit;


        int minPrice = prices[0], maxProfit = 0;
        for(int i = 0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i]-minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
