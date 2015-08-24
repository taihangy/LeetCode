public class MinimumPathSum{
    //应该也算动态规划问题，当前的值等于当前行前一列的值加上当前列上一行的值
	public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i>0&&j>0) grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                else if(i>0) grid[i][j]=grid[i-1][j]+grid[i][j];
                else if(j>0) grid[i][j]=grid[i][j-1]+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}