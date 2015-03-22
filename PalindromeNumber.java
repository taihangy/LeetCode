public class PalindromeNumber{
	public boolean isPalindrome(int x){
		if(x<0) return false;
		int count=1;
		//不能对x造成破坏
		int temp=x;
		//计算最高位对应的100...000
		while(temp>=10){
			temp=temp/10;
			count=count*10;
		}
		//若第一位不等于最后一位，则返回false；否则去除第一为和最后一位，count除以100后继续检查
		while(x>0){
			if(x/count!=x%10) return false;
			x=(x%count)/10;
			count=count/100;
		}
		return true;
	}
}