public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n <= 0) return res;
        helper(n, 0, new int[n], res);
        return res;
    }
    
    private void helper(int n, int row, int[] colAtRow, List<List<String>> res) {
        if(row == n) {
            List<String> solution = new ArrayList<String>();
            for(int i = 0; i < colAtRow.length; i++) {
                int pos = colAtRow[i];
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(j == pos) sb.append('Q');
                    else sb.append('.');
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }
        for(int i = 0; i < n; i++) {
            colAtRow[row] = i;
            if(check(row, colAtRow)) {
                helper(n, row + 1, colAtRow, res);
            }
        }
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