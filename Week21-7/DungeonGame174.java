public class Solution {
    //TLE
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return -1;
        int[] min = {Integer.MAX_VALUE};
        helper(dungeon, 0, 0, dungeon[0][0], min);
        return min[0];
    }
    
    private void helper(int[][] dungeon, int i, int j, int sum, int[] min) {
        //This way need more health so just stop
        if(sum < 0 && -sum + 1 > min[0]) return;
        if(i == dungeon.length && j == dungeon[0].length) {
            int health = sum > 0? 1 : -sum + 1;
            min[0] = Math.min(min[0], health);
            return;
        }
        if(i + 1 < dungeon.length) 
            helper(dungeon, i + 1, j, sum + dungeon[i + 1][j], min);
        if(j + 1 < dungeon[0].length) 
            helper(dungeon, i, j + 1, sum + dungeon[i][j + 1], min);
    }

    //DP
    public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return -1;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m - 1][n - 1] = Math.max(-dungeon[m - 1][n - 1] + 1, 1);
        for(int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for(int i = n - 2; i >= 0; i--) {
            health[m - 1][i] = Math.max(health[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int down = Math.max(1, health[i + 1][j] - dungeon[i][j]);
                int right = Math.max(1, health[i][j + 1] - dungeon[i][j]);
                health[i][j] = Math.min(down, right);
            }
        }
        return health[0][0];
    }
}
}