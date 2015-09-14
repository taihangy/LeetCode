public class Solution {
    // recursive solution
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 || n == 1) return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}

//  use an array to store infomation
// there are at most two ways to reach a point, from up and from left
// so we can add count[j - 1] and count[j], then we got the total ways to get to the current position
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[] count = new int[n];
        count[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                count[j] = count[j - 1] + count[j];
            }
        }
        return count[n - 1];
    }
}