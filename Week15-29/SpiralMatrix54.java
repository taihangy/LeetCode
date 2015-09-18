public class Solution {
    // 4 loops and corner case
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int layer = Math.min(m, n) / 2;
        
        for(int l = 0; l < layer; l++) {
            for(int i = l; i < n - l - 1; i++) res.add(matrix[l][i]);
            for(int i = l; i < m - l - 1; i++) res.add(matrix[i][n - 1 - l]);
            for(int i = n - 1 - l; i > l; i--) res.add(matrix[m - 1 - l][i]);
            for(int i = m - 1 - l; i > l; i--) res.add(matrix[i][l]);
        }
        if(Math.min(m, n) % 2 == 1) {
            if(m < n) {
                for(int i = layer; i < n - layer; i++) res.add(matrix[layer][i]);
            }
            else {
                for(int i = layer; i < m - layer; i++) res.add(matrix[i][layer]);
            }
        }
        return res;
    }

    // general solution set a direction array, start at [0, -1], first go right, then down, then left, then up. For example, in a 3 * 5 matrix, first go right 5, then go down for 2, then left for 4, then up for 1, step[5, 2], then step[4, 1]
    // also we can do counterclockwise spiral
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] step = {n, m - 1};
        int dir = 0;
        int row = 0, col = -1;
        while(step[dir % 2] != 0) {
            for(int i = 0; i < step[dir % 2]; i++) {
                row += dirs[dir][0];
                col += dirs[dir][1];
                res.add(matrix[row][col]);
            }
            step[dir % 2]--;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}