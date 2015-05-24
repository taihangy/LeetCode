public class WordBreak{
	public boolean wordBreak(String s, Set<String> wordDict) {
        //时间复杂度O(n^2)，空间复杂度O(n)
        //res保存到j位置之前是否是由word组成，如果不是则删去str第一个字符，j++后再判断
        if(s==null||s.length()==0||wordDict.isEmpty()) return false;
        boolean[] res=new boolean[s.length()+1];
        res[0]=true;
        for(int i=0;i<s.length();i++){
            StringBuilder str=new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j]&&wordDict.contains(str.toString())){
                    res[i+1]=true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    //时间复杂度O(sizeof(wordDict)+maxLen*n)
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null||s.length()==0||wordDict.isEmpty()) return false;
        boolean[] res=new boolean[s.length()+1];
        int maxLen=getMax(wordDict);
        res[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=i&&j<=maxLen;j++){
                if(!res[i-j]) continue;
                String word=s.substring(i-j,i);
                if(wordDict.contains(word)){
                    res[i]=true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
    private int getMax(Set<String> wordDict){
        int maxLen=0;
        for(String word:wordDict){
            if(word.length()>maxLen)
                maxLen=word.length();
        }
        return maxLen;
    }
}