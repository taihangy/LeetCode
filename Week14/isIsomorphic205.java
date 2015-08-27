public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // check parameters
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        // hashmap maps character in s to character in t
        HashMap<Character, Character> sToT = new HashMap<Character, Character>();
        // hashset is recording which character in t is mapped by character in s
        // if it is being using and another new character in s want to map with that it will return false
        HashSet<Character> dup = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            char charInS = s.charAt(i);
            char charInT = t.charAt(i);
            if(!sToT.containsKey(charInS)) {
                if(!dup.contains(charInT)) {
                    sToT.put(charInS, charInT);
                    dup.add(charInT);
                }
                else {
                    return false;
                }
            } 
            else {
                char corresp = sToT.get(charInS);
                if(charInT != corresp) {
                    return false;
                }
            }
        }
        return true;
    }
}