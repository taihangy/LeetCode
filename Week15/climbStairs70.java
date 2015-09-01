public class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int[] res = new int[n];
        res[0] = 1; 
        res[1] = 2;
        for(int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }

}