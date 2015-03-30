public class UniquePaths2{
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m<1||n<1||obstacleGrid[m-1][n-1]==1) return 0;
        return helper(1,1,m,n,obstacleGrid);
    }
    public int helper(int row,int col,int m,int n,int[][] obstacleGrid){
        if(row==m&&col==n) return 1;
        if(row>m||col>n||obstacleGrid[row-1][col-1]==1) return 0;
        return helper(row+1,col,m,n,obstacleGrid)+helper(row,col+1,m,n,obstacleGrid);
    }

    //动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m==0||n==0||obstacleGrid[m-1][n-1]==1) return 0;
        int[] res=new int[n];
        res[0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) res[j]=0;
                else {
                    if(j>0)
                        res[j]+=res[j-1];
                }
            }
        }
        return res[n-1];
    }
}