public class WordBreak2{
	//brute froce 时间复杂度太高，当所有都是一样的时候
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

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(s==null||s.length()==0||dict.isEmpty()) return new ArrayList<String>();
        Map<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        return helper(s,dict,map);
    }
    private ArrayList<String> helper(String s,Set<String> dict,Map<String,ArrayList<String>> map){
        if(map.containsKey(s)) return map.get(s);
        ArrayList<String> res=new ArrayList<String>();
        for(int len=1;len<=s.length();len++){
            String str=s.substring(0,len);
            if(dict.contains(str)){
                if(len==s.length()){
                    res.add(str);
                }
                else{
                    String sub=s.substring(len);
                    ArrayList<String> temp=helper(sub,dict,map);
                    for(String item:temp){
                        item=str+" "+item;
                        res.add(item);
                    }
                }
            }
        }
        map.put(s,res);
        return res;
    }
    //DP version figure out later
}