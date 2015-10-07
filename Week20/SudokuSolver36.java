public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int i, int j) {
        if(j == 9){
            return helper(board, i + 1, 0);
        }
        if(i == 9) return true;
        if(board[i][j] == '.') {
            for(int k = 1; k <= 9; k++) {
                board[i][j] = (char)(k + '0');
                if(isValid(board, i, j) && helper(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        }
        else {
            return helper(board, i, j+1);
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j) {
        char c = board[i][j];
        for(int m = 0; m < 9; m++) {
            if(j != m && c == board[i][m]) return false;
        }
        
        for(int m = 0; m < 9; m++) {
            if(i != m && c == board[m][j]) return false;
        }

        int row = i / 3, col = j / 3;
        for(int m = row * 3; m < row * 3 + 3; m++) {
            for(int n = col * 3; n < col * 3 + 3; n++) {
                if(m != i && n != j && c == board[m][n]) return false;   
            }
        }
        return true;
    }
}