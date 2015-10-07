public class Solution {
    // recursion will cause stack overflow
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int[] max = new int[1];
        max[0] = Integer.MAX_VALUE;
        findPath(grid, 0, 0, 0, max);
        return max[0];
    }
    
    private void findPath(int[][] grid, int i, int j, int sum, int[] max) {
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            sum = sum + grid[i][j];
            if(sum < max[0]) {
                max[0] = sum;
            }
            return;
        }
        if(i < grid.length - 1) findPath(grid, i + 1, j, sum + grid[i][j], max);
        if(j < grid[0].length - 1) findPath(grid, i, j + 1, sum + grid[i][j], max);
    }

    // DP version, time O(m * n), space O(n)
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int row = grid.length, col = grid[0].length;
        int[] sum = new int[col];
        sum[0] = grid[0][0];
        for(int i = 1; i < col; i++) {
            sum[i] = sum[i - 1] + grid[0][i];
        }
        for(int i = 1; i < row; i++) {
            sum[0] += grid[i][0];
            for(int j = 1; j < col; j++) {
                sum[j] = Math.min(sum[j - 1], sum[j]) + grid[i][j];
            }
        }
        return sum[col - 1];
    }
}