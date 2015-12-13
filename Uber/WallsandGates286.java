public class Solution {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        List<int[]> zeros = new ArrayList<int[]>();
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }
        for(int[] zeroPos : zeros) {
            bfs(zeroPos[0], zeroPos[1], rooms);
        }
    }
    
    private void bfs(int i, int j, int[][] rooms) {
        boolean[][] marked = new boolean[rooms.length][rooms[0].length];
        marked[i][j] = true;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{i, j});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] near : neighbor(cur, rooms, marked)) {
                int x = near[0], y = near[1];
                marked[x][y] = true;
                if(rooms[cur[0]][cur[1]] + 1 < rooms[x][y]) {
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                }
                q.offer(near);
            }
        }
    }
    
    private List<int[]> neighbor(int[] cur, int[][] rooms, boolean[][] marked) {
        List<int[]> res = new ArrayList<int[]>();
        for(int i = 0; i < dir.length; i++) {
            int x = dir[i][0] + cur[0];
            int y = dir[i][1] + cur[1];
            if(x >= 0 && x < rooms.length && 
               y >= 0 && y < rooms[0].length &&
               !marked[x][y] && rooms[x][y] != 0 && rooms[x][y] != -1) {
                   res.add(new int[]{x, y});
               }
        }
        return res;
    }
}