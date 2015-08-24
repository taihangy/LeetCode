public class SearchInsertPosition{
    //就是binary search
	public int searchInsert(int[] A, int target) {
        int index=-1;
        if(A==null||A.length==0) return index;
        int lo=0;
        int hi=A.length-1;
        int mid=(lo+hi)/2;
        while(hi>lo){
            if(A[mid]<target){
                lo=mid+1;
                mid=(lo+hi)/2;
            } else if(A[mid]>target){
                hi=mid-1;
                mid=(lo+hi)/2;
            } else{
                index=mid;
                return index;
            }
        }
        if(target<=A[lo]) return lo;
        else return lo+1;
    }

    public int searchInsert(int[] A, int target) {
        if(A==null||A.length==0) return 0;
        int lo=0;
        int hi=A.length-1;
        int mid=(lo+hi)/2;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(target==A[mid])
                return mid;
            else if(target<A[mid])
                hi=mid-1;
            else 
                lo=mid+1;
        }
        return lo;
    }
}