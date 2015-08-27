public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                HashSet<Integer> sudokuGrid = new HashSet<Integer>();
                for(int m = i; m < i + 3; m++) {
                    for(int n = j; n < j + 3; n++) {
                        if(board[m][n] == '.') continue;
                        else if(board[m][n] - '0' > 9 || board[m][n] - '0' < 0 || sudokuGrid.contains(board[m][n] - '0')) {
                            return false;
                        } else {
                            sudokuGrid.add(board[m][n] - '0');
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < 9; i++) {
            HashSet<Integer> sudokuGrid = new HashSet<Integer>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                else if(board[i][j] - '0' > 9 || board[i][j] - '0' < 0 || sudokuGrid.contains(board[i][j] - '0')) {
                    return false;
                } else {
                    sudokuGrid.add(board[i][j] - '0');
                }
            }
        }
        
        for(int j = 0; j < 9; j++) {
            HashSet<Integer> sudokuGrid = new HashSet<Integer>();
            for(int i = 0; i < 9; i++) {
                if(board[i][j] == '.') continue;
                else if(board[i][j] - '0' > 9 || board[i][j] - '0' < 0 || sudokuGrid.contains(board[i][j] - '0')) {
                    return false;
                } else {
                    sudokuGrid.add(board[i][j] - '0');
                }
            }
        }
        return true;
    }
}