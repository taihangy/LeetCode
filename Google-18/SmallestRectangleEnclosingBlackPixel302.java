public class Solution {
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int[] boundary = {x, x, y, y};
        findBoundary(image, new boolean[image.length][image[0].length], boundary, x, y);
        return (boundary[1] - boundary[0] + 1) * (boundary[3] - boundary[2] + 1);
    }
    
    private void findBoundary(char[][] image, boolean[][] marked, int[] boundary, int x, int y) {
        marked[x][y] = true;
        
        if(x < boundary[0]) boundary[0] = x;
        else if(x > boundary[1]) boundary[1] = x;
        if(y < boundary[2]) boundary[2] = y;
        else if(y > boundary[3]) boundary[3] = y;
        
        for(int[] near : neighbor(image.length, image[0].length, x, y)) {
            int newx = near[0], newy = near[1];
            if(!marked[newx][newy] && image[newx][newy] == '1') {
                findBoundary(image, marked, boundary, newx, newy);
            }
        }
        
    }
    
    private List<int[]> neighbor(int m, int n, int i, int j) {
        List<int[]> res= new ArrayList<int[]>();
        for(int k = 0; k < 4; k++) {
            int x = dirX[k] + i, y = dirY[k] + j;
            if(x >= 0 && x < m && y >= 0 && y < n) {
                res.add(new int[]{x, y});
            }
        }
        return res;
    }
}