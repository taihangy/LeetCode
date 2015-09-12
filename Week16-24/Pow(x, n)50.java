public class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || n == 0) return 1.0;
        double res = 1.0;
        for(int i = n; i != 0; i /= 2, x *= x) 
            if(i % 2 != 0) res *= x;
        return n < 0? 1 / res : res;
    }
}