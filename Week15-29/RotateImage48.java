public class Solution {
    public void rotate(int[][] matrix) {
        // time O(n * n), space O(1)
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int[] storage = new int[n];
        int layer = n / 2;
        for(int level = 0; level < layer; level++) {
            System.arraycopy(matrix[level], level, storage, level, n - 2 * level - 1);
            for(int i = n - level - 1; i > level; i--) matrix[level][n - i - 1] = matrix[i][level];
            for(int i = n - level - 1; i > level; i--) matrix[i][level] = matrix[n - 1 - level][i];
            for(int i = level; i < n - 1 - level; i++) matrix[n - 1 - level][n - i - 1] = matrix[i][n - 1 - level];
            for(int i = level; i < n - 1 - level; i++) matrix[i][n - 1 - level] = storage[i];
        }
    }
}