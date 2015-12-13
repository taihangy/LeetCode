public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int[] min = costs[0];
        for(int i = 1; i < m; i++) {
            int[] next = costs[i];
            for(int j = 0; j < n; j++) {
                next[j] = findMin(min, j) + costs[i][j];
            }
            min = next;
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < min.length; i++) {
            minCost = Math.min(minCost, min[i]);
        }
        return minCost;
    }
    
    private int findMin(int[] min, int j) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < min.length; i++) {
            if(i == j) continue;
            res = Math.min(res, min[i]);
        }
        return res;
    }
}