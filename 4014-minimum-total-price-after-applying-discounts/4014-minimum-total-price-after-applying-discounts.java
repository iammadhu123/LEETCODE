class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int j = discounts.length - 1;
        double ans = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (j >= 0) {
                ans += prices[i] * (100 - discounts[j]) / 100.0;
                j--;
            } else {
                ans += prices[i];
            }
        }

        return ans;
    }
}