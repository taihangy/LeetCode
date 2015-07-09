public class PlusOne{
	public int[] plusOne(int[] digits){
		int len=digits.length;
		if(digits==null||len==0)
			return digits;
		int carry=1;
		for(int i=len-1;i>=0;i--){
			int digit=(digits[i]+carry)%10;
			carry=(digits[i]+carry)/10;
			digits[i]=digit;
			if(carry==0)		//carry一旦为0即可停止进位
				return digits;
		}
		int[] res=new int[len+1]; //如果最高位依旧要依旧要进位，即999...999
		res[0]=1;				//设置新的最高位为1
		return res;
	}
	public static void main(String args[]){
		PlusOne po=new PlusOne();
//		int[] a1=null;
		int[] a2={1,2,3,9,9};
		int[] a3={9,9,9,9,9};
//		int[] a4={};
//		int[] b1=po.plusOne(a1);
		int[] b2=po.plusOne(a2);
		int[] b3=po.plusOne(a3);
//		int[] b4=po.plusOne(a4);
/*		System.out.println("a1's result:");
		for(int num:a1)
			System.out.print(num+" ");
*/
		System.out.println("a2's result:");
		for(int num:b2)
			System.out.print(num+" ");
		System.out.println("\na3's result:");
		for(int num:b3)
			System.out.print(num+" ");
/*
		System.out.println("a4's result:");
		for(int num:a4)
			System.out.print(num+" ");
*/
	}
}