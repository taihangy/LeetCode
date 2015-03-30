public class UniquePaths{
	public int uniquePaths(int m,int n){
		if(m<1||n<1) return 0;
		return helper(1,1,m,n);
	}
	public int helper(int row,int col,int m,int n){
		if(row==m&&col==n) return 1;
		if(row>m||col>n) return 0;
		return helper(row+1,col,m,n)+helper(row,col+1,m,n);
	}

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