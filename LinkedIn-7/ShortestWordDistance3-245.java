public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if(word1.equals(word2)) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) list.add(i);
            }
            for(int i = 0; i < list.size() - 1; i++) {
                min = Math.min(min, list.get(i + 1) - list.get(i));
            }
        } else {
            int p1 = -1, p2 = -1;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    p1 = i;
                }
                else if(words[i].equals(word2)) {
                    p2 = i;
                }
                if(p1 != -1 && p2 != -1) {
                    min = Math.min(min, Math.abs(p1 - p2));
                }
            }
        }
        return min;
    }
}