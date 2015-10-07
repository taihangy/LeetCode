public class Solution {
    /** Kadane's algorithm
    * All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.
    *
    * Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero. 
    */
    public int maxProfit(int[] prices) {
        assert prices != null;
        int res = 0, today = 0;
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            today = Math.max(0, today + diff);
            res = Math.max(today, res);
        }
        return res;
    }

    // find minPrice from 0 to i, maxPro
    public int maxProfit(int[] prices) {
        assert prices != null;
        int maxPro = 0, minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, price[i]);
            maxPro = Math.max(maxPro, price[i] - minPrice);
        }
        return maxPro;
    }
}