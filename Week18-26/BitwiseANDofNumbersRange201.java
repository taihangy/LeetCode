public class Solution {
    // if m..n is long, it will take O(n - m) 
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for(int i = m; i <= n; i++) {
            res &= i;
        }
        return res;
    }

    /** bitwise AND all numbers in the range m..n*/
    // Find the first bit difference from the right, right part would be zero, left part would be result (because they are same)
    // O(1) after 32 shift left it will be the same
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
}