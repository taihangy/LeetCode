public class Solution {
    // sometimes it doesn't need to use hash map, especially when String is a - z or A - Z or 236 ASCII
    public boolean isAnagram(String s, String t) {
        // parameter checking
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        // add character in s string to hashmap
        HashMap<Character, Integer> charInS = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if(!charInS.containsKey(character))
                charInS.put(character, 1);
            else {
                int count = charInS.get(character) + 1;
                charInS.put(character, count);
            }
        }
        
        // reduce corresponding count in hashmap
        for(int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if(!charInS.containsKey(character)) {
                return false;
            }
            else {
                int count = charInS.get(character) - 1;
                if(count < 0) return false;
                charInS.put(character, count);
            }
        }
        
        // check whether number of each character's counts are equal to zero
        for(int count : charInS.values()) {
            if(count != 0) return false;
        }
        
        return true;
    }

    // use array instead of hashmap
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for(int i = 0; i < s.length(); i++) if(alphabet[i] != 0) return false;
        return true;
    }
}