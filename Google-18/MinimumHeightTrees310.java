public class Solution {
    // Memory exceed
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) return res;
        int minHeight = Integer.MAX_VALUE;
        // Neighbors of each node
        HashMap<Integer, List<Integer>> neighbors = new HashMap<Integer, List<Integer>>();
        // Initialize the neighbors
        for (int i = 0; i < n; i++) {
            List<Integer> neighbor = new ArrayList<Integer>();
            neighbors.put(i, neighbor);
        }
        for (int i = 0; i < edges.length; i++) {
            List<Integer> first = neighbors.get(edges[i][0]);
            List<Integer> second = neighbors.get(edges[i][1]);
            first.add(edges[i][1]);
            second.add(edges[i][0]);
            neighbors.put(edges[i][0], first);
            neighbors.put(edges[i][1], second);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int level = 0;
            boolean[] marked = new boolean[n];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);
            marked[i] = true;
            int lastNum = 1;
            int curNum = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                lastNum--;
                for (int near : neighbors.get(cur)) {
                    if (!marked[near]) {
                        marked[near] = true;
                        queue.offer(near);
                        curNum++;
                    }
                }
                if (lastNum == 0) {
                	lastNum = curNum;
                	level++;
                }
            }
            map.put(i, level);
        }
        for (int level : map.values()) {
            minHeight = Math.min(minHeight, level);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(i) == minHeight) {
                res.add(i);
            }
        }
        return res;
    }
}

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) return new ArrayList<Integer>();
        else if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
        for (int i = 0; i < n; i++) adj.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newleaves = new ArrayList<Integer>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newleaves.add(j);
            }
            leaves = newleaves;
        }
        return leaves;
    }
}