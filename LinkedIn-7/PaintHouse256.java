public class Solution {
    //TLE 
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int[] min = {Integer.MAX_VALUE};
        for(int i = 0; i < costs[0].length; i++) 
            dfs(costs, min, costs[0][i], 0, i);
        return min[0];
    }
    
    private void dfs(int[][] costs, int[] min, int cost, int level, int start) {
        if(level == costs.length - 1) {
            min[0] = Math.min(min[0], cost);
            return;
        }
        if(start == 0 || start == 2) dfs(costs, min, cost + costs[level + 1][1], level + 1, 1);
        else {
            dfs(costs, min, cost + costs[level + 1][0], level + 1, 0);
            dfs(costs, min, cost + costs[level + 1][2], level + 1, 2);
        }
    }

    //DP
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int row = costs.length, col = costs[0].length;
        int[] min = costs[0];
        for(int i = 1; i < row; i++) {
            int[] copy = costs[i];
            for(int j = 0; j < col; j++) {
                int left = 0, right = 0;
                switch(j) {
                    case 0: left = min[1]; right = min[2]; break;
                    case 1: left = min[0]; right = min[2]; break;
                    case 2: left = min[0]; right = min[1]; break;
                }
                copy[j] = Math.min(left, right) + costs[i][j];
            }
            min = copy;
        }
        int minCost = min[0];
        for(int i = 1; i < min.length; i++) {
            minCost = Math.min(minCost, min[i]);
        }
        return minCost;
    }
}