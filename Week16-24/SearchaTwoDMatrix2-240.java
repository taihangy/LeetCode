public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int low = m - 1, high = m - 1;
        for(int i = 0; i < m; i++) {
            if(target == matrix[i][n - 1]) return true;
            else if(target < matrix[i][n - 1]) {
                low = i;
                break;
            }
        }
        for(int i = 0; i < m; i++) {
            if(target == matrix[i][0]) return true;
            else if( target < matrix[i][0]) {
                high = i - 1;
                break;
            }
        }
        for(int i = low; i <= high; i++) {
            int[] row = matrix[i];
            int p = 0, q = n - 1;
            while(p <= q) {
                int mid = (p + q) / 2;
                if(row[mid] == target) return true;
                else if(target > row[mid]) p = mid + 1;
                else q = mid - 1;
            }
        }
        return false;
    }
}