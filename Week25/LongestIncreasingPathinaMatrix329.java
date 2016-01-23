public class Solution {
    //TLE
    private static int[] dir = {-1, 0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxLength = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int local = dfs(i, j, new boolean[m][n], matrix, maxLength);
                maxLength[i][j] = local;
                max = Math.max(max, local);
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, boolean[][] marked, int[][] matrix, int[][] maxLength) {
        if (maxLength[i][j] != 0) return maxLength[i][j];
        marked[i][j] = true;
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k];
            int y = j + dir[k + 1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
                !marked[x][y] && matrix[x][y] > matrix[i][j]) {
                int res = dfs(x, y, marked, matrix, maxLength);
                max = Math.max(max, res);
            }
        }
        marked[i][j] = false;
        return max + 1;
    }

    public class Solution {
    private static int[] dir = {-1, 0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxLength = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int local = dfs(i, j, matrix, maxLength);
                max = Math.max(max, local);
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] maxLength) {
        if (maxLength[i][j] != 0) return maxLength[i][j];
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k];
            int y = j + dir[k + 1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                int res = dfs(x, y, matrix, maxLength);
                max = Math.max(max, res);
            }
        }
        maxLength[i][j] = max + 1;
        return max + 1;
    }
}
}