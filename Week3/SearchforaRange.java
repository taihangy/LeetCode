public class SearchforaRange{
	public int[] SearchforaRange(int[] A,int target){
		res[0]=-1;res[1]=-1;
        if(A==null||A.length==0) return res;
        int lo=0,hi=A.length-1;
        int i=-1,j=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(target==A[mid]){
                for(i=mid+1;i<=hi;i++)
                    if(target!=A[i]) break;
                for(j=mid-1;j>=lo;j--)
                    if(target!=A[j]) break;
                res[0]=j+1;
                res[1]=i-1;
                return res;
            }else if(target>A[mid]){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return res;
	}
}