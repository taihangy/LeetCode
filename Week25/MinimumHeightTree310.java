public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Params check
        if (n == 0) return new ArrayList<Integer>();
        else if (n == 1) return Collections.singletonList(0);
        // Initial the adjecnt list of each node
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // Find the "leave" node in the tree, which has no children and has just one "parent" node
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        // Iteratively remove the leave nodes until there are no more than 2 nodes left
        while (n > 2) {
            n -= leaves.size();
            // Find new leave nodes after removing old leaves from their parent node
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int leave : leaves) {
                int parent = adj.get(leave).iterator().next();
                adj.get(parent).remove(leave);
                if (adj.get(parent).size() == 1) newLeaves.add(parent);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}