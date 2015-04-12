public class FindMinimuminRotatedSortedArray{
	public int findMin(int[] num){
		//和带有target的那题类似，采用二分法
		if(num==null||num.length==0) return -1;
		int lo=0,hi=num.length-1;
		int min=num[0];
		while(lo<=hi){
			int mid=(lo+hi)/2;
			if(num[mid]<num[lo]){
				min=Math.min(min,num[mid]);
				hi=mid-1;
			}
			//这里有可能num[mid]>=num[lo]，因为mid==lo是可能的
			//这个时候要让lo=mid+1（lo++当mid==lo时就是mid+1），包含了两个情况，当然也可以分开来写
			else{
				min=Math.min(min,num[lo]);
				lo=mid+1;
			}
		}
		return min;
	}
}