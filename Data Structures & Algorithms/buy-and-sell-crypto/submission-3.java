class Solution {
    public int maxProfit(int[] prices) {
        // Sliding Window Approach
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while(right < prices.length) {
            // book profit
            if(prices[left] < prices[right]) {
                int currProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currProfit);
            }// buying time
            else if(prices[left] > prices[right]) {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
