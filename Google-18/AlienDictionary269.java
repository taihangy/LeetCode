public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        // Each character has its own parents(indegree)
        HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();
        // Each character has its own direct children(outdegree)
        HashMap<Character, HashSet<Character>> outDegree = new HashMap<Character, HashSet<Character>>();
        
        // Initialize every character in alien lib with indegree 0
        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegree.put(c, 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int minlen = Math.min(cur.length(), next.length());
            for(int j = 0; j < minlen; j++) {
                char cc = cur.charAt(j);
                char nc = next.charAt(j);
                if(cc != nc) {
                    HashSet<Character> out = new HashSet<Character>();
                    if(outDegree.containsKey(cc)) {
                        out = outDegree.get(cc);
                    }
                    if(!out.contains(nc)) {
                        out.add(nc);
                        outDegree.put(cc, out);
                        inDegree.put(nc, inDegree.get(nc) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> orderSeq = new LinkedList<Character>();
        for(char c : inDegree.keySet()) {
            if(inDegree.get(c) == 0) {
                orderSeq.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!orderSeq.isEmpty()) {
            char c = orderSeq.poll();
            res.append(c);
            if(outDegree.containsKey(c)) {
                for(char nc : outDegree.get(c)) {
                    inDegree.put(nc, inDegree.get(nc) - 1);
                    if(inDegree.get(nc) == 0) {
                        orderSeq.offer(nc);
                    }
                }
            }
        }
        if(res.length() != inDegree.size()) return "";
        return res.toString();
    }
}