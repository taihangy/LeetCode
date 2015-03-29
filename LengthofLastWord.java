public class LengthofLastWord{
	public int lengthOfLastWord(String s){
		if(s==null||s.length()==0) return 0;
		s=s.trim();
		if(s.length()==0) return 0;
		String strs[]=s.split(" ");
		return strs[strs.length-1].length();
	}
}