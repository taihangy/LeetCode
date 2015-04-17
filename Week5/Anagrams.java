public class Anagrams {
    public List<String> anagrams(String[] strs) {
       List<String> res=new ArrayList<String>();
       if(strs==null||strs.length==0) return res;
       HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
       for(int i=0;i<strs.length;i++){
           char[] charArray=strs[i].toCharArray();
           Arrays.sort(charArray);
           String s=new String(charArray);
           if(map.containsKey(s)){
               ArrayList<String> list=map.get(s);
               list.add(strs[i]);
           }else{
               ArrayList<String> list=new ArrayList<String>();
               list.add(strs[i]);
               map.put(s,list);
           }
       }
       Iterator iter=map.values().iterator();
       while(iter.hasNext()){
           ArrayList<String> item=(ArrayList<String>)iter.next();
           if(item.size()>1){
               res.addAll(item);
           }
       }
       return res;
    }
}