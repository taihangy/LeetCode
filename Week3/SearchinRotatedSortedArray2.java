public class SearchinRotatedSortedArray2{
	public boolean search(int[] A, int target) {
        if(A==null||A.length==0) return false;
        int lo=0;
        int hi=A.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(target==A[mid]) return true;
            if(A[mid]>A[lo]){
                if(A[mid]>target&&A[lo]<=target) hi=mid-1;
                else                             lo=mid+1;
            }else if(A[mid]<A[lo]){
                if(A[mid]<target&&A[hi]>=target) lo=mid+1;
                else                             hi=mid-1;
            }else{
                lo++;
            }
        }
        return false;
    }

    public boolean search(int[] A, int target) {
        if(A==null||A.length==0) return false;
        int lo=0;
        int hi=A.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(target==A[mid]) return true;
            if(A[mid]>A[hi]){
                if(A[mid]>target&&A[lo]<=target) hi=mid-1;
                else                             lo=mid+1;
            }else if(A[mid]<A[hi]){
                if(A[mid]<target&&A[hi]>=target) lo=mid+1;
                else                             hi=mid-1;
            }else{
                hi--;
            }
        }
        return false;
    }
}