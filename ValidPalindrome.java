public class ValidPalindrome{
	public boolean isPalindrome(String s){
		if(s==null) return false;
		if(s.length()==0) return true;
		s=s.toLowerCase();
		s=s.replaceAll("[^0-9a-z]+","");
		for(int i=0,j=s.length()-1;i<s.length()/2&&j>s.length()/2;i++,j--){
			if(s.charAt(i)!=s.charAt(j)) return false;
		}
		return true;
	}
}