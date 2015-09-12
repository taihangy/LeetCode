public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        for(int i = 0; i < x / 2; i++) {
            if(i * i <= x && (i + 1) * (i + 1) > x) return i;
        }
        return 0;
    }
}
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int lo = 1, hi = x / 2 + 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if( mid <= x / mid && mid + 1 > x / (mid + 1)) return mid;
            if(mid > x / mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return 0;
    }
}