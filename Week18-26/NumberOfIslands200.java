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

// Union Find Solution
public class Solution {
    private class UF {
        private int[] id;
        private int[] size;
        private int count;
        
        public UF(int N) {
            this.id = new int[N];
            this.size = new int[N];
            this.count = N;
            for(int i = 0; i < N; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }
        
        public int count() { return count; }
        
        public int find(int p) {
            while(p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if(pRoot == qRoot) return;
            if(size[p] < size[q]) {
                id[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                id[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
            count--;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int row = grid.length, col = grid[0].length;
        UF uf = new UF(row * col + 1);
        int dummyPoint = row * col;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    if(i < row - 1 && grid[i + 1][j] == '1') uf.union(i * col + j, (i + 1) * col + j);
                    if(j < col - 1 && grid[i][j + 1] == '1') uf.union(i * col + j, i * col + j + 1);
                } else {
                    uf.union(i * col + j, dummyPoint);
                }
            }
        }
        return uf.count() - 1;
    }
}