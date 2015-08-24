public class MultiplyStrings{
	public String multiply(String num1,String num2){
		//此题很锻炼思维
		//首先两数相乘肯定是M+N或者M+N-1位
		//因此，每i位上的数等于第一个数字的1位*第二个数字的i位+第一个数字的2位*第二个数字的i-1位..
		//当然每个数字不能超过i位以及每个数字的最长位数
		//注意最高位进位为0时就不用加入
		//空间复杂度因为只需要保存一个num，O(1)，时间复杂度O((m+n)^2)
		if(num1==null||num2==null||num1.length()==0||num2.length()==0)
			return "";
		if(num1.charAt(0)=='0'||num2.charAt(0)=='0')
			return "0";
		StringBuilder res=new StringBuilder();
		int N=num1.length();
		int M=num2.length();
		int num=0;
		for(int i=1;i<=N+M;i++){
			for(int j=1;j<=Math.min(N,i);j++){
				if(i-j+1<=M){
					num+=(num1.charAt(N-j)-'0')*(num2.charAt(M-(i-j+1))-'0');
				}
			}
			if(num>0||i!=N+M)
				res.append(num%10);
			num/=10;
		}
		return res.reverse().toString();
	}
}