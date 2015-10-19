public class Solution {
    public boolean wordPattern(String pattern, String str) {
        assert pattern != null;
        HashMap<String, Character> stringToChar = new HashMap<String, Character>();
        HashMap<Character, String> charToString = new HashMap<Character, String>();
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = strs[i];
            if(!charToString.containsKey(c) && !stringToChar.containsKey(word)) {
                charToString.put(c, word);
                stringToChar.put(word, c);
            }
            else if(charToString.containsKey(c) && stringToChar.containsKey(word)) {
                if(stringToChar.get(word) != c) return false;
            }
            else return false;
        }
        return true;
    }
}