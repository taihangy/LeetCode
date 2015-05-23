public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null) return false;
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            if(!map.containsKey(schar)){
                if(!map.containsValue(tchar))
                    map.put(schar,tchar);
                else
                    return false;
            }
            else
            {
                if(tchar!=map.get(schar)){
                    return false;
                }
            }
        }
        return true;
    }
}