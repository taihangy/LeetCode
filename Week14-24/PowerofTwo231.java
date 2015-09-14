public class Solution {
	// nothing to say, time O(logn), space O(1)
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n != 1) {
            if(n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}