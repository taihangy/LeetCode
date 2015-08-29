public class Solution {
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
}