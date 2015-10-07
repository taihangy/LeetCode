public class Solution {
    // easy version of word ladder 2
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) return 0;
        int states = 1, lastNum = 1, curNum = 0;
        LinkedList<String> path = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        path.offer(beginWord);
        visited.add(beginWord);
        while(!path.isEmpty()) {
            String last = path.poll();
            lastNum--;
            for(int i = 0; i < last.length(); i++) {
                char[] lastChar = last.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    lastChar[i] = c;
                    String cur = new String(lastChar);
                    if(cur.equals(endWord)) return states + 1;
                    if(wordList.contains(cur) && visited.add(cur)) {
                        curNum++;
                        path.offer(cur);
                    }
                }
            }
            if(lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                states++;
            }
        }
        return 0;
    }
}