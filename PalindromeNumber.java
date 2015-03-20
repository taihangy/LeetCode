public class PalindromeNumber{
	public boolean isPalindrome(int x){
		if(x<0) return false;
		int count=1;
		int temp=x;
		while(temp>=10){
			temp=temp/10;
			count=count*10;
		}
		while(x>0){
			if(x/count!=x%10) return false;
			x=(x%count)/10;
			count=count/100;
		}
		return true;
	}
}