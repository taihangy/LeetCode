public class LongestSubstringWithoutRepeatingCharacters{
	public int lengthOfLongestSubstring(String s) {
        //brute force O(n^2) 空间O(n)
        if(s==null||s.length()==0) return 0;
        int maxLen=0;
        HashSet<Character> set=new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                char val=s.charAt(j);
                if(set.add(val)) continue;
                else{
                    maxLen=set.size()>maxLen?set.size():maxLen;
                    set.clear();
                    break;
                } 
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int N=s.length();
        int lo=0,hi=0;
        int max=0;
        HashSet<Character> set=new HashSet<Character>();
        //只有在出现重复元素的时候改变max的值
        while(hi<N){
            if(!set.add(s.charAt(hi))){
                if(max<hi-lo) max=hi-lo;
                //消除那些重复元素之前的元素
                while(s.charAt(lo)!=s.charAt(hi)){
                    set.remove(s.charAt(lo));
                    lo++;
                }
                //消除重复元素
                lo++;
            }
            hi++;
        }
        //注意最后一个考虑都不重复的时候，max无法更新，因此要比较
        int res=max>(hi-lo)?max:hi-lo;
        return res;
    }
}