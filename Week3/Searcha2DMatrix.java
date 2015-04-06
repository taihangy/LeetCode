public class Searcha2DMatrix{
	public boolean searchMatrix(int[][] matrix,int target){
		if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
		int m=matrix.length,n=matrix[0].length;
		int lo=0,hi=m-1;
		int index=0;
		while(lo<=hi){
			index=(lo+hi)/2;
			if(target==matrix[index][n-1]) return true;
			else if(target>matrix[index][n-1]){
				if(index+1<m&&matrix[index+1][n-1]==target) return true;
				else if(index+1<m&&matrix[index+1][n-1]>target) {
					index++;
					break;
				}
				else lo=index+1;
			}else{
				if(index-1>=0&&matrix[index-1][n-1]==target) return true;
				else if(index-1>=0&&matrix[index-1][n-1]<target) break;
				else hi=index-1;
			}
		}
		int l=0,r=n-1;
		while(l<=r){
			int mid=(l+r)/2;
			if(target==matrix[index][mid]) return true;
			else if(target>matrix[index][mid]) l=mid+1;
			else r=mid-1;
		}
		return false;
	}
}