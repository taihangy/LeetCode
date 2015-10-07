public class Solution {
    public int maxProfit(int[] prices) {
        assert prices != null;
        int[] todayTran = new int[3];
        int[] res = new int[3];
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for(int j = 2; j >= 1; j--) {
                todayTran[j] = Math.max(todayTran[j] + diff, res[j - 1] + (diff > 0? diff : 0));
                res[j] = Math.max(todayTran[j], res[j]);
            }
        }
        return res[2];
    }
}