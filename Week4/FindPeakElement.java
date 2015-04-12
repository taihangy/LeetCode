public class FindPeakElement{
	public int findPeakElement(int[] num){
		if(num==null||num.length==0) return -1;
		if(num.length==1) return 0;
		return helper(num,0,num.length-1);
	}
	private int helper(int[] num,int lo,int hi){
		//若hi和lo是相等则返回lo
		if(lo==hi) return lo;
		//相差1，也就是1和0的时候若果1大，那么1就是peak，否则0就是，因为0肯定比-1的负无穷要大
		if(hi-lo==1) return num[lo]>num[hi]?lo:hi;
		int mid=(lo+hi)/2;
		//如果mid比两边都大，那就是mid
		if(num[mid]>num[mid-1]&&num[mid]>num[mid+1]) return mid;
		//如果mid比左边小，则左边肯定有peak，因为假设mid-1大于mid-2，那么mid-1就是peak
		//否则继续比较mid-2和mid-3，一直可以比较到1和0
		else if(num[mid]<num[mid-1]) return helper(num,lo,mid-1);
		//右侧类似
		else return helper(num,mid+1,hi);
	}
}