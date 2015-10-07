public class Solution {
    // Time O(kn), space O(k)
    public int maxProfit(int k, int[] prices) {
        assert prices != null;
        if(k >= prices.length) return buyMany(prices);
        int[] todayTran = new int[k + 1];
        int[] res = new int[k + 1];
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for(int j = k; j >= 1; j--) {
                todayTran[j] = Math.max(todayTran[j] + diff, res[j - 1] + (diff > 0? diff : 0));
                res[j] = Math.max(todayTran[j], res[j]);
            }
        }
        return res[k];
    }
    
    // if k is too large just do transaction as if there is any profit
    private int buyMany(int[] prices) {
        assert prices != null;
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            max += diff > 0? diff : 0;
        }
        return max;
    }
}