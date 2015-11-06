public class Solution {
    public int totalNQueens(int n) {
        if(n <= 0) return 0;
        return helper(n, 0, new int[n]);
    }
    
    private int helper(int n, int row, int[] colAtRow) {
        if(row == n) {
            return 1;
        }
        int number = 0;
        for(int i = 0; i < n; i++) {
            colAtRow[row] = i;
            if(check(row, colAtRow)) {
                number += helper(n, row + 1, colAtRow);
            }
        }
        return number;
    }
    
    private boolean check(int row, int[] colAtRow) {
        for(int i = 0; i < row; i++) {
            if(colAtRow[i] == colAtRow[row] ||
               Math.abs(row - i) == Math.abs(colAtRow[row] - colAtRow[i])) {
                   return false;
               }
        }
        return true;
    }
}