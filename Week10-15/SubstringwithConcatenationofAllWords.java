public class Solution {
    //这样的题，就是用HashMap，保存词与对于个数，然后去遍历，每次减去最左边重复或是应该要删去（继续下一步）的词
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<Integer>();
        if(words==null||words.length==0) return res;
        int wordLen=words[0].length();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else{
                map.put(words[i],1);
            }
        }
        
        for(int i=0;i<wordLen;i++){
            HashMap<String,Integer> curMap=new HashMap<String,Integer>();
            int left=i;
            int count=0;
            for(int j=i;j<=s.length()-wordLen;j+=wordLen){
               String word=s.substring(j,j+wordLen);
               if(map.containsKey(word)){
                   if(curMap.containsKey(word)){
                      curMap.put(word,curMap.get(word)+1);
                   }
                   else{
                      curMap.put(word,1);
                   }
                   if(curMap.get(word)<=map.get(word)){
                       count++;
                   }
                   else{
                       while(curMap.get(word)>map.get(word)){
                           String rep=s.substring(left,left+wordLen);
                           if(curMap.containsKey(rep)){
                               curMap.put(rep,curMap.get(rep)-1);
                               if(curMap.get(rep)<map.get(rep))
                                  count--;
                           }
                           left+=wordLen;
                       }
                   }
                   if(count==words.length){
                       res.add(left);
                       String rep=s.substring(left,left+wordLen);
                       if(curMap.containsKey(rep)){
                          curMap.put(rep,curMap.get(rep)-1); 
                       }
                       count--;
                       left+=wordLen;
                   }
               }
               else{
                   curMap.clear();
                   count=0;
                   left=j+wordLen;
               }
            }
        }
        return res;
    }
}