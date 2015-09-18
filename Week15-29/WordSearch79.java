public class Solution {
    // dfs from all the point 
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word == null || word.length() == 0) return true;
        boolean[][] marked = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(wordSearch(board, marked, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean wordSearch(char[][] board, boolean[][] marked, String word, int i, int j, int index) {
        if(index == word.length()) return true;
        // isValid position
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
                 || marked[i][j] || board[i][j] != word.charAt(index)) return false;
        marked[i][j] = true;
        boolean res = wordSearch(board, marked, word, i + 1, j, index + 1) ||
                      wordSearch(board, marked, word, i - 1, j, index + 1) ||
                      wordSearch(board, marked, word, i, j + 1, index + 1) ||
                      wordSearch(board, marked, word, i, j - 1, index + 1) ;
        // need to make marked false, because other point will use it again
        marked[i][j] = false;
        return res;
    }
}