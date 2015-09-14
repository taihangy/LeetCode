public class Solution {
    // normal one
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        HashSet<Integer> result = new HashSet<Integer>();
        int res = squareSum(n);
        while(res != 1) {
            result.add(res);
            res = squareSum(res);
            if(result.contains(res)) {
                return false;
            }  
        }
        return true;
    }
    
    private int squareSum(int x) {
        int res = 0;
        while(x != 0) {
            int digit = x % 10;
            res += digit * digit;
            x = x / 10;
        }
        return res;
    }

    // You could refer to wikipedia, search for 'happy number', then you could find that for any unhappy number, they will fall into one specific loop "4->16->37->...->2->4
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        while(n != 1) {
            n = squareSum(n);
            if(n == 4) return false;
        }
        return true;
    }
}