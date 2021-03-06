public class SearchinRotatedSortedArray{
	//为binary search变体
	public int search(int[] A,int target){
		if(A==null||A.length==0) return -1;
		int lo=0;
		int hi=A.length-1;
		while(lo<=hi){
			int mid=(lo+hi)/2;
			if(target==A[mid]) return mid;
			if(A[mid]>A[hi]){
				if(target<A[mid]&&target>=A[lo]) 
					hi=mid-1;
				else 	
					lo=mid+1;
			}else{
				if(target>A[mid]&&target<=A[hi])
					lo=mid+1;
				else 
					hi=mid-1;
			}
		}
		return -1;
	}

	public int search(int[] A,int target){
		if(A==null||A.length==0) return -1;
		int lo=0;
		int hi=A.length-1;
		while(lo<=hi){
			//注意mid有可能和lo相等（因为当lo==hi时，mid==lo==hi）
			//因此A[mid]<A[lo]时右边有序，A[mid]>=A[lo]左边有序（注意不要漏了等于）
			int mid=(lo+hi)/2;
			if(target==A[mid]) return mid;
			if(A[mid]<A[lo]){
				if(target>A[mid]&&target<=A[hi]) 
					lo=mid+1;
				else 	
					hi=mid-1;
			}else{
				if(target<A[mid]&&target>=A[lo])
					hi=mid-1;
				else 
					lo=mid+1;
			}
		}
		return -1;
	}
}