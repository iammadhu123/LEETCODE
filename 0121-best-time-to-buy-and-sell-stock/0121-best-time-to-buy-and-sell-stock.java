class Solution {
    public int maxProfit(int prices[]) {
        int maxProfit = 0;
        int buyingPrice = prices[0];
        for(int i = 1; i<prices.length; i++) {
            buyingPrice = Math.min(prices[i], buyingPrice);
            maxProfit = Math.max(maxProfit, prices[i]-buyingPrice);
        }
        return maxProfit;
    }
}