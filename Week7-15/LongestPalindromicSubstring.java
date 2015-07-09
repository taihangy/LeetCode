public class LongestPalindromicSubstring{
	//从n个数字与n-1各夹缝中向两边找，如果相同则继续，保存最大值
	public String longestPalindrome(String s){
		if(s==null||s.length()==0) return "";
		int maxLen=0;
		Stringtring res=null;
		for(int i=0;i<2*s.length()-1;i++){
			int left=i/2;
			int right=i/2;
			if(i%2==1) right++;
			String palin=palindrome(s,left,right);
			if(maxLen<palin.length()){
				res=palin;
				maxLen=palin.length();
			}
		}
		return res;
	}
	private Stirng palindrome(String s,int left,int right){
		while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}
}