public class Solution {
    // bfs without marked
    private static int[] dirX = {+1, -1, 0, 0};
    private static int[] dirY = {0, 0, +1, -1}; 
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        // Mark all O from the egdes to 'T'
        for(int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for(int i = 1; i < n - 1; i++) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char c = board[i][j];
                switch(c) {
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case 'F':
                        board[i][j] = 'O';
                        break;
                }
            }
        }
    }
    
    private void bfs(char[][] board, int i, int j) {
        if(board[i][j] != 'O') return;
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            board[x][y] = 'F';
            for(int[] near : neighbor(board, x, y, board.length, board[0].length))
                queue.offer(near);
        }
    }
    
    private List<int[]> neighbor(char[][] board, int i, int j, int m, int n) {
        List<int[]> res = new ArrayList<int[]>();
        for(int k = 0; k < 4; k++) {
            int nearI = i + dirX[k];
            int nearJ = j + dirY[k];
            int[] dir = new int[]{nearI, nearJ};
            if(nearI >= 0 && nearI < m &&
               nearJ >= 0 && nearJ < n && 
               board[nearI][nearJ] == 'O') {
                board[nearI][nearJ] = 'T';
                res.add(dir);
            }
        }
        return res;
    }

    // bfs by using marked
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        // Mark all O from the egdes to 'T'
        boolean[][] marked = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            if(!marked[i][0] && board[i][0] == 'O') bfs(board, marked, i, 0);
            if(!marked[i][n - 1] && board[i][n - 1] == 'O') bfs(board, marked, i, n - 1);
        }
        for(int i = 1; i < n - 1; i++) {
            if(!marked[0][i] && board[0][i] == 'O') bfs(board, marked, 0, i);
            if(!marked[m - 1][i] && board[m - 1][i] == 'O') bfs(board, marked, m - 1, i);
        }
        
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(!marked[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, boolean[][] marked, int i, int j) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        marked[i][j] = true;
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for(int[] near : neighbor(board, marked, x, y))
                queue.offer(near);
        }
    }
    
    private List<int[]> neighbor(char[][] board, boolean[][] marked, int i, int j) {
        int m = board.length, n = board[0].length;
        List<int[]> res = new ArrayList<int[]>();
        for(int k = 0; k < dirX.length; k++) {
            int nearI = i + dirX[k];
            int nearJ = j + dirY[k];
            int[] dir = new int[]{nearI, nearJ};
            if(nearI >= 0 && nearI < m &&
               nearJ >= 0 && nearJ < n && 
               board[nearI][nearJ] == 'O' && !marked[nearI][nearJ]) {
                marked[nearI][nearJ] = true;
                res.add(dir);
            }
        }
        return res;
    }
     
    // dfs stack over flow, but it can do the job
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    
   public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        // Mark all O from the egdes to 'T'
        for(int i = 0; i < m; i++) {
            if(!marked[i][0] && board[i][0] == 'O') dfs(board, marked, i, 0);
            if(!marked[i][n - 1] && board[i][n - 1] == 'O') dfs(board, marked, i, n - 1);
        }
        for(int i = 1; i < n - 1; i++) {
            if(!marked[0][i] && board[0][i] == 'O') dfs(board, marked, 0, i);
            if(!marked[m - 1][i] && board[m - 1][i] == 'O') dfs(board, marked, m - 1, i);
        }
        
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(!marked[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, boolean[][] marked, int i, int j) {
        marked[i][j] = true;
        for(int[] near : neighbor(i, j, board.length, board[0].length)) {
            int nearI = near[0], nearJ = near[1];
            if(!marked[nearI][nearJ] && board[nearI][nearJ] == 'O') {
                dfs(board, marked, nearI, nearJ);
            }
        }
    }
    
    private List<int[]> neighbor(int i, int j, int m, int n) {
        List<int[]> res = new ArrayList<int[]>();
        for(int k = 0; k < dirX.length; k++) {
            int nearI = i + dirX[k];
            int nearJ = j + dirY[k];
            int[] dir = new int[]{nearI, nearJ};
            if(nearI >= 0 && nearI < m && nearJ >= 0 && nearJ < n) {
                res.add(dir);
            }
        }
        return res;
    }
}