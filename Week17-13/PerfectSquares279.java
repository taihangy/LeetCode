public class Solution {
    /**
    * DP 
    */
    public int numSquares(int n) {
        if(n <= 0) return 0;
        int[] res = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                minNum = Math.min(minNum, res[i - j * j] + 1);
            }
            res[i] = minNum;
        }
        return res[n];
    }
}