public class Solution {
    // you need treat n as an unsigned value
    // Using O(n) extra space and O(n) time
    public int reverseBits(int n) {
        int[] digits = new int[32];
        if(n < 0) {
            // flip the first bit
            n = n ^ Integer.MIN_VALUE;
            digits[31] = 1;
        }
        for(int i = 0; i < 31; i++) {
            digits[i] = n % 2;
            n /= 2;
        }
        int res = 0;
        for(int i = 1; i < 32; i++) {
            res = res * 2 + digits[i];
        }
        // make res negtive by | Integer.MIN_VALUE
        return digits[0] == 1? res | Integer.MIN_VALUE : res;
    }

    // more compact way, by using O(1) space
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }
}