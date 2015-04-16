public class LongestSubstringWithoutRepeatingCharacters{
	public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character> set=new HashSet<Character>();
            for(int j=i;j<s.length();j++){
                char val=s.charAt(j);
                if(set.add(val)) continue;
                else{
                    maxLen=set.size()>maxLen?set.size():maxLen;
                    break;
                } 
            }
        }
        return maxLen;
    }
}