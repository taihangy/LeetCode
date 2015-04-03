public class SpiralMatrix2{
	public int[][] generateMatrix(int n){
		int[][] res=new int[n][n];
		if(n<=0) return res;
		int levelNum=n/2;
		int num=1;
		for(int level=0;level<levelNum;level++){
			for(int i=level;i<n-1-level;i++) res[level][i]=num++;
			for(int i=level;i<n-1-level;i++) res[i][n-1-level]=num++;
			for(int i=n-1-level;i>level;i--) res[n-1-level][i]=num++;
			for(int i=n-1-level;i>level;i--) res[i][level]=num++;
		}
	if(n%2==1) res[levelNum][levelNum]=num;
	return res;
	}
}