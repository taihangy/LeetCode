public class Solution {
    public int numWays(int n, int k) {
        if(n <= 0 || k <= 0) return 0;
        else if(n == 1) return k;
        int diff = k * (k - 1);
        int same = k;
        int temp = 0;
        for(int i = 2; i < n; i++) {
            temp = diff;
            diff = (k - 1) * (same + diff);
            same = temp;
        }
        return same + diff;
    }
}