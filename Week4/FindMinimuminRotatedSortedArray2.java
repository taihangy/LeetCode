public class FindMinimuminRotatedSortedArray2{
	public int findMin(int[] num){
		if(num==null||num.length==0) return -1;
		int lo=0,hi=num.length-1;
        int min=num[0];
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(num[mid]<num[lo]){
                min=Math.min(num[mid],min);
                hi=mid-1;
            }else if(num[mid]>num[lo]){
                min=Math.min(min,num[lo]);
                lo=mid+1;
            }else{
                min=Math.min(min,num[lo]);
                lo++;
            }
        }
        return min;
	}
}