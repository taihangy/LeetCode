public class SearchforaRange{
    //binary search的变体，先找到一个，然后前后搜索，这种方法比较慢，因为最差可能要O(n)
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

    //用两次binary search寻找左边缘与右边缘
    public int[] searchRange(int[] A,int target){
        int[] res={-1,-1};
        if(A==null||A.length==0) return res;
        int ll=0,lr=A.length-1;
        while(ll<=lr){
            int m=(ll+lr)/2;
            if(A[m]<target) ll=m+1;
            else            lr=m-1;
        }
        int rl=0,rr=A.length-1;
        //这种时候要考虑最后一步当rr==rl时还没有停止，
        //无非是A[m]<=target rl=m+1，此时要么小于是因为没有搜索到，要么等于是搜索到了还在增长，此时rr就为右边缘
        //或者A[m]>target rr=m-1，此时A[m]显然大于targetrr=m-1（其实m==rr==rl）这时刚好rr也为右边缘
        while(rl<=rr){
            int m=(rl+rr)/2;
            if(A[m]>target) rr=m-1;
            else            rl=m+1;
        }
        //如果找到了
        if(ll<=rr){
            res[0]=ll;
            res[1]=rr;
            return res;
        }
        //如果没找到
        return res;
    }
}