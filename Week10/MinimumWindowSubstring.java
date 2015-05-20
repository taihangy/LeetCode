public class Solution {
    public String minWindow(String s, String t) {
        if(t==null||t.length()==0&&s!=null) return "";
        if(s==null||s.length()<t.length()) return "";
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i),1);
            }
        }
        int left=0;
        int minLen=s.length()+1;
        int minStart=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)-1);
                if(map.get(cur)>=0) count++;
                while(count==t.length()){
                    if(i-left+1<minLen){
                        minLen=i-left+1;
                        minStart=left;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left))>0)
                            count--;
                    }
                    left++;
                }
            }
        }
        if(minLen>s.length()) return "";
        return s.substring(minStart,minStart+minLen);
    }
}