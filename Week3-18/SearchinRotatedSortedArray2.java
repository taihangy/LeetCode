public class SearchinRotatedSortedArray2{
	public boolean search(int[] A, int target) {
        if(A==null||A.length==0) return false;
        int lo=0;
        int hi=A.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(target==A[mid]) return true;
            //此处有三种情况：
            //前两种和之前的类似，小于lo则向右，大于lo则向左
            //当等于的时候就无法判断向右还是向左，因此需要lo++，看是否相等，因此worst case就是O(n),也就是全相等
            //这和quicksort相似，如果不shuffle就会很惨。。
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