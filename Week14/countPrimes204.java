public class Solution {
    public int countPrimes(int n) {
        if(n < 2) {
            return 0;
        }
        
        boolean[] marked = new boolean[n];
        int count = 0;
        for(int i = 2; i * i <= n - 1; i++) {
            if(marked[i]) continue;
            for(int dup = i * i; dup <= n - 1; dup += i) {
                if(!marked[dup]) {
                    marked[dup] = true;
                    count++;
                }
            }
        }
        return n - 2 - count;
    }
}