public class Solution {

    // clever way but nothing to say about it
    public int addDigits(int num) {
        int sum = 1 + (num - 1) % 9;
        return sum;
    }

    public int addDigits(int num) {
        if(num < 0) return -1;
        if(num < 10) return num;
        
        while(num >= 10) {
            int sum = 0;
            while(num > 0) {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}