public class MaximumSubarray{
	//DP问题，保持global和local，local就是包含当前元素的最大值，global是全局的最大值
	//local是前一位的local+A[i]和A[i]的比较，因为前一位local可能是负值
	//global是old global和当前local的比较
	public int maxSubArray(int[] A){
		if(A==null||A.length==0) return 0;
		int local=A[0];
		int global=A[0];
		for(int i=1;i<A.length;i++){
			local=Math.max(A[i]+local,A[i]);
			global=Math.max(global,local);
		}
		return global;
	}
}