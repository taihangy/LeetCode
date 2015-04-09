public class FindPeakElement{
	public int findPeakElement(int[] num){
		if(num==null||num.length==0) return -1;
		if(num.length==1) return 0;
		return helper(num,0,num.length-1);
	}
	private int helper(int[] num,int lo,int hi){
		if(lo==hi) return lo;
		if(hi-lo==1) return num[lo]>num[hi]?lo:hi;
		int mid=(lo+hi)/2;
		if(num[mid]>num[mid-1]&&num[mid]>num[mid+1]) return mid;
		else if(num[mid]<num[mid-1]) return helper(num,lo,mid-1);
		else return helper(num,mid+1,hi);
	}
}