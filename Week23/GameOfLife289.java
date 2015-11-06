public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        int[][] copyboard = new int[row][col];
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                copyboard[i][j] = board[i][j];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(copyboard[i][j] == 1) {
                    int alive = neighbor(copyboard, i, j);
                    if(alive < 2 || alive > 3) {
                        board[i][j] = 0;
                    } 
                }
                else {
                    int alive = neighbor(copyboard, i, j);
                    if(alive == 3) {
                        board[i][j] = 1;
                    } 
                }
            }
        }
    }
    
    private int neighbor(int[][] board, int i, int j) {
        int count = 0;
        for(int m = i - 1; m <= i + 1; m++) {
            for(int n = j - 1; n <= j + 1; n++) {
                if(m == i && n == j) continue;
                if(m >= 0 && m < board.length && 
                   n >= 0 && n < board[0].length && board[m][n] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int count = 0;
                for(int m = Math.max(0, i - 1); m < Math.min(row, i + 2); m++) {
                    for(int n = Math.max(0, j - 1); n < Math.min(col, j + 2); n++) {
                        if((board[m][n] & 1) == 1) count++;
                    }
                }
                if(count == 3 || count - board[i][j] == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                board[i][j] >>= 1;
    }
}