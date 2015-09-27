public class Solution {
    // using dfs every node would visit once, O(m * n) time
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    private int isLand;
    
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
        for(int k = 0; k < 4; k++) {
            int x = dirX[k] + i, y = dirY[k] + j;
            if(x >= 0 && x < m && y >= 0 && y < n) {
                res.add(new int[]{x, y});
            }
        }
        return res;
    }

    // why time limit exceed? Because every time find neighbor we should set that neighbor to true, so next time would not visit again
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int island = 0;
        int m = grid.length, n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<int[]>();
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!marked[i][j] && grid[i][j] == '1') {
                    marked[i][j] = true;
                    queue.offer(new int[]{i, j});
                    island++;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0], y = cur[1];
                        for(int[] near : neighbor(m, n, x, y)) {
                            int nearX = near[0], nearY = near[1];
                            if(!marked[nearX][nearY] && grid[nearX][nearY] == '1') {
                                marked[nearX][nearY] = true; // is very important
                                queue.offer(near);
                            }
                        }
                    }
                }
            }
        }
        return island;
    }
    
    private List<int[]> neighbor(int m, int n, int i, int j) {
        List<int[]> res= new ArrayList<int[]>();
        for(int k = 0; k < 4; k++) {
            int x = dirX[k] + i, y = dirY[k] + j;
            if(x >= 0 && x < m && y >= 0 && y < n) {
                res.add(new int[]{x, y});
            }
        }
        return res;
    }
}