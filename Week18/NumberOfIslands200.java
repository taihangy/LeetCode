public class Solution {
    private int isLand = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!marked[i][j] && grid[i][j] == '1') {
                    helper(grid, marked, i, j);
                    isLand++;
                }
            }
        }
        return isLand;
    }
    
    private void helper(char[][] grid, boolean[][] marked, int i, int j) {
        marked[i][j] = true;
        for(int[] near : neighbor(grid.length, grid[0].length, i, j)) {
            int nearI = near[0], nearJ = near[1];
            if(!marked[nearI][nearJ] && grid[nearI][nearJ] == '1') {
                helper(grid, marked, nearI, nearJ);
            }
        }
    }
    
    private List<int[]> neighbor(int m, int n, int i, int j) {
        List<int[]> res= new ArrayList<int[]>();
        int[][] directions = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
        for(int k = 0; k < directions.length; k++) {
            int[] direction = directions[k];
            if(direction[0] >= 0 && direction[0] < m &&
               direction[1] >= 0 && direction[1] < n) {
                   res.add(direction);
               }
        }
        return res;
    }
}