public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[] delta = {0, 1, 0, -1, 0};
        int minDist = Integer.MAX_VALUE;
        int[][] total = new int[m][n];
        List<boolean[][]> visits = new ArrayList<boolean[][]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[m][n];
                    int[][] dist = new int[m][n];
                    visits.add(visited);
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int ii = cur[0], jj = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nearI = ii + delta[d];
                            int nearJ = jj + delta[d + 1];
                            if (nearI >= 0 && nearI < m && 
                                nearJ >= 0 && nearJ < n && 
                                grid[nearI][nearJ] == 0 && !visited[nearI][nearJ]) {
                                dist[nearI][nearJ] = dist[ii][jj] + 1;
                                total[nearI][nearJ] += dist[nearI][nearJ];
                                queue.offer(new int[]{nearI, nearJ});
                                visited[nearI][nearJ] = true;
                            }
                        }
                    }
                }
            }
        }
        int[] min = new int[2];
        for (int i = 0; i < m; i++) {
        	outloop:
            for (int j = 0; j < n; j++) {
                if(total[i][j] == 0) continue;
                if(minDist > total[i][j]) {
                	for(boolean[][] visited : visits) {
                        if(!visited[i][j]) continue outloop;
                    }
                    minDist = total[i][j];
                    min[0] = i;
                    min[1] = j;
                }
            }
        }
        return minDist == Integer.MAX_VALUE? -1 : minDist;
    }
}