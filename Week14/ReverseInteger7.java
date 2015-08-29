public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if(x < 0) {
            isNeg = true;
            x = -x;
        }
        int sum = 0;
        while(x != 0) {
            int digit = x % 10;
            if(!isNeg && sum > (double)((Integer.MAX_VALUE - digit) / 10)) return 0;
            if(isNeg && - sum  < (double)((Integer.MIN_VALUE + digit) / 10)) return 0;
            sum = sum * 10 + digit;
            x = x / 10;
        }
        return isNeg? -sum : sum;
    }
}