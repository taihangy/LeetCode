public class Solution {
		/** "arrogance is the first thing you want to avoid during interview". Exactly. Also true in your daily life =)
		* if I was from the future I would buy stock according to this joke.
		*/
    public int maxProfit(int[] prices) {
        assert prices != null;
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            res += diff > 0? diff : 0;
        }
        return res;
    }
}