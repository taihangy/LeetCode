public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            List<Integer> l = map.get(edges[i][0]);
            l.add(edges[i][1]);
            map.put(edges[i][0], l);
            List<Integer> l1 = map.get(edges[i][1]);
            l1.add(edges[i][0]);
            map.put(edges[i][1], l1);
        }
        int count = 0;
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!marked[i]) {
                dfs(marked, map, i);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(boolean[] marked, HashMap<Integer, List<Integer>> map, int i) {
        marked[i] = true;
        for (int j : map.get(i)) {
            if (!marked[j]) {
                dfs(marked, map, j);
            }
        }
    }
}