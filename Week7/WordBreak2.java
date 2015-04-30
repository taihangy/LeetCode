public class WordBreak2{
	//brute froce
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res=new ArrayList<String>();
        if(s==null||s.length()==0||wordDict.isEmpty()) return res;
        helper(s,wordDict,0,"",res);
        return res;
    }
    private void helper(String s,Set<String> wordDict,int start,String item,List<String> res){
        if(start>=s.length()){
            res.add(item);
            return;
        } 
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<s.length();i++){
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString())){
                String newItem=item.length()>0?item+" "+sb.toString():sb.toString();
                helper(s,wordDict,i+1,newItem,res);
            }
        }
    }
    //DP version figure out later
}