public class ReverseBits{
	public int reverseBits(int n){
		int[] bits=new int[32];
		int sum=0;
		//思路和Numberof1Bits基本一致，记住n^Integer.MIN_VALUE
		if(n<0){
			n=n^Integer.MIN_VALUE;
			bits[31]=1;
		}
		for(int i=0;i<bits.length-1;i++){
			bits[i]=n%2;
			n/=2;
		}
		//符号位别算进去
		for(int i=1;i<bit.length;i++){
			sum=2*sum+bits[i];
		}
		return bits[0]==1?-sum:sum;
	}
}