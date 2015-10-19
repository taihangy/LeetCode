public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0) return res;
        int wordlen = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String word : words) {
            if(map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        for(int i = 0; i <= s.length() - words.length * wordlen; i++) {
            if(map.containsKey(s.substring(i, i + wordlen))) {
                Map<String, Integer> curMap = new HashMap<String, Integer>();
                for(int j = 0; j < words.length; j++) {
                    String word = s.substring(i + j * wordlen, i + (j + 1) * wordlen);
                    if(map.containsKey(word)) {
                        curMap.put(word, curMap.containsKey(word)?curMap.get(word) + 1 : 1);
                        if(curMap.get(word) > map.get(word)) break;
                    } else break;
                }
                if(map.equals(curMap)) res.add(i);
            }
        }
        return res;
    }
}