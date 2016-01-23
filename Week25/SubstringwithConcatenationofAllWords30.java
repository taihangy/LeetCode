public class Solution {
     public List<Integer> findSubstring(String s, String[] words) {
         List<Integer> res = new ArrayList<Integer>();
         if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
         HashMap<String, Integer> wordCount = new HashMap<>();
         for (String word : words) {
             if (wordCount.containsKey(word)) {
                 wordCount.put(word, wordCount.get(word) + 1);
             }
             else {
                 wordCount.put(word, 1);
             }
         }
         int size = words.length;
         int len = words[0].length();
         for (int i = 0; i < len; i++) {
             int start = i;
             int count = 0;
             HashMap<String, Integer> curCount = new HashMap<>();
             for (int j = i; j <= s.length() - len; j += len) {
                 String word = s.substring(j, j + len);
                 if (wordCount.containsKey(word)) {
                     if (curCount.containsKey(word)) {
                         curCount.put(word, curCount.get(word) + 1);
                     }
                     else {
                         curCount.put(word, 1);
                     }
                     if (curCount.get(word) <= wordCount.get(word)) {
                         count++;
                     }
                     else {
                         while (curCount.get(word) > wordCount.get(word)) {
                             String prevWord = s.substring(start, start + len);
                             if (curCount.containsKey(prevWord)) {
                                 curCount.put(prevWord, curCount.get(prevWord) - 1);
                                 if (curCount.get(prevWord) < wordCount.get(prevWord)) {
                                     count--;
                                 }
                             }
                             start += len;
                         }
                     }
                     if (count == size) {
                         res.add(start);
                         String prevWord = s.substring(start, start + len);
                         if (curCount.containsKey(prevWord)) {
                             curCount.put(prevWord, curCount.get(prevWord) - 1);
                         }
                         count--;
                         start += len;
                     }
                 }
                 else {
                     curCount.clear();
                     start = j + len;
                     count = 0;
                 }
             }
         }
         return res;
    }
}