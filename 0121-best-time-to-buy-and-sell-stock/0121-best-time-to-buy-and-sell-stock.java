class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int curr_min = prices[0];
        int max_p = 0;
        for( int i = 0; i < n; i++)
        {
            curr_min = Math.min(curr_min, prices[i]);
            int profit = prices[i] - curr_min;
            max_p = Math.max(profit, max_p);
        }
        return max_p;
    }
}