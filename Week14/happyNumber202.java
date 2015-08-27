public class Solution {
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
}