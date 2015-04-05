public class UniquePaths{
    //递归解法
	public int uniquePaths(int m,int n){
		if(m<1||n<1) return 0;
		return helper(1,1,m,n);
	}
	public int helper(int row,int col,int m,int n){
        //递归出口，当走到m，n时是一种解法
		if(row==m&&col==n) return 1;
        //当走出边界则返回0
		if(row>m||col>n) return 0;
        //递归体，每一格是可以向右和向下，则，这两种走法的和即该格的总走法
		return helper(row+1,col,m,n)+helper(row,col+1,m,n);
	}

    //每一格的值为上一行同列的格子的值加上同一行前一列格子的值，有点类似杨辉三角，空间复杂度O(n)其实可以O(min(n,m))
	public int uniquePaths(int m, int n) {
        if(m<0||n<0) return 0;
        int[] res=new int[n];
        res[0]=1;
        for(int i=0;i<m;i++)
            for(int j=1;j<n;j++){
                res[j]+=res[j-1];
            }
        return res[n-1];
    }

    //纯数学解法，就是向下走m-1步，向左走n-1步，在m+n-2步中取m-1或者n-1步
    public int uniquePaths(int m,int n){
    	if(m<0||n<0) return 0;
    	double x=m+n-2;
    	double y=m<n?m-1:n-1;
    	for(int i=0;i<(int)y-1;i++){
    		x*=x-1;
    		y*=y-1;
    	}
    	return (int)(x/y);
    }
}