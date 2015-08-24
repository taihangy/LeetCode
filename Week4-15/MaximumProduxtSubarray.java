public class MaximumProductSubarray{
	//DP问题，要保持min_local和max_local因为最小复制乘以负是可能变大的，以及global的max
	public int maxProduct(int[] A){
		if(A==null||A.length==0) return 0;
		int maxLocal=A[0];
		int minLocal=A[0];
		int global=A[0];
		for(int i=1;i<A.length;i++){
			//此处的local值，要在A[i],A[I]*max_local,A[i]*min_local之中诞生
			int temp=maxLocal;
			maxLocal=Math.max(Math.max(A[i]*maxLocal,A[i]),minLocal*A[i]);
			minLocal=Math.min(Math.min(A[i]*temp,A[i]),minLocal*A[i]);
			global=Math.max(global,maxLocal);
		}
		return global;
	}
}