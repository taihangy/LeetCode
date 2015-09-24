public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for(int i = m; i <= n; i++) {
            res ^= i;
        }
        return res;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
}