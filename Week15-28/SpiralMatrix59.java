public class Solution {
    // like spiral matrix 54, the same solution
    public int[][] generateMatrix(int n) {
        int[][] res= new int[n][n];
        if(n == 0) return res;
        int layer = n / 2;
        int elem = 1;
        for(int level = 0; level < layer; level++) {
            for(int i = level; i < n - level - 1; i++) res[level][i] = elem++;
            for(int i = level; i < n - level - 1; i++) res[i][n - 1 - level] = elem++;
            for(int i = n - 1 - level; i > level; i--) res[n - 1 - level][i] = elem++;
            for(int i = n - 1 - level; i > level; i--) res[i][level] = elem++;
        }
        if(n % 2 == 1)
            res[layer][layer] = elem;
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] res= new int[n][n];
        if(n == 0) return res;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] step = {n, n - 1};
        int row = 0, col = -1, dir = 0, elem = 1;
        while(step[dir % 2] != 0) {
            for(int i = 0; i < step[dir % 2]; i++) {
                row += dirs[dir][0];
                col += dirs[dir][1];
                res[row][col] = elem;
                elem++;
            }
            step[dir % 2]--;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}