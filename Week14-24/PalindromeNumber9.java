public class Solution {
    // time O(n), space O(1)
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int count = 1;
        int xCopy = x;
        while(xCopy >= 10) {
            xCopy /= 10;
            count *= 10;
        }
        while(x > 0) {
            if(x / count != x % 10) return false;
            x = (x % count) / 10;
            count /= 100;
        }
        return true;
    }

    // reverse of x is x, is much simpler
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int reverseX = 0;
        while(x > 0) {
            reverseX = 10 * reverseX + x % 10;
            x /= 10;
        }
        if(reverseX == num) return true;
        return false;
    }
}