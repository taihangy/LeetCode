public class Solution {
    // time O(m * n), space O(1)
    // by using the first row and column of the matrix to save the info whether this line should be set to zero
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        boolean row = false, col = false;
        for(int i = 0; i < matrix[0].length; i++) {
            row = matrix[0][i] == 0? true : false;
            if(row) break;
        }
        for(int i = 0; i < matrix.length; i++) {
            col = matrix[i][0] == 0? true : false;
            if(col) break;
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        for(int i = 1; i <matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j <matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row) {
            for(int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        if(col) {
            for(int i = 0; i <matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}