public class Solution {
    // first bfs add distance and children, then dfs find path
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(wordList == null || wordList.size() == 0) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        bfs(beginWord, endWord, map, distance, wordList);
        List<String> path = new ArrayList<String>();
        dfs(beginWord, endWord, path, map, distance, res);
        return res;
    }
    private void dfs(String end, String cur, List<String> path, 
                     HashMap<String, List<String>> map, HashMap<String, Integer> distance, List<List<String>> res) {
        path.add(cur);
        if(cur.equals(end)) {
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for(String prev : map.get(cur)) {
                if(distance.containsKey(prev) && distance.get(prev) + 1== distance.get(cur)) {
                    dfs(end, prev, path, map, distance, res);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
    private void bfs(String beginWord, String endWord, HashMap<String, List<String>> map, 
                     HashMap<String, Integer> distance, Set<String> wordList) {
        for(String word : wordList) {
            map.put(word, new ArrayList<String>());
        }
        distance.put(beginWord, 0);
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            ArrayList<String> expansions = expand(cur, wordList);
            for(String exp : expansions) {
                map.get(exp).add(cur);
                if(!distance.containsKey(exp)) {
                    distance.put(exp, distance.get(cur) + 1);
                    queue.offer(exp);
                }
            }
        }
    }
    
    private ArrayList<String> expand(String cur, Set<String> wordList) {
        ArrayList<String> expansions = new ArrayList<String>();
        for(int i = 0; i < cur.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != cur.charAt(i)) {
                    String newS = cur.substring(0, i) + c + cur.substring(i + 1);
                    if(wordList.contains(newS)) {
                        expansions.add(newS);
                    }
                }
            }
        }
        return expansions;
    }
}