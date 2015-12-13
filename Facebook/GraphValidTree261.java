// DFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n <= 0 || edges == null) return false;
        // Initial graph
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
        // Add egdges
        for(int i = 0; i < edges.length; i++) {
            int v = edges[i][0], w = edges[i][1];
            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        // Check cycle
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] marked = new boolean[n];
        stack.push(0);
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(marked[v]) return false;
            marked[v] = true;
            for(int w : graph.get(v)) {
                stack.push(w);
                graph.get(w).remove(v);
            }
        }
        // Check connected
        for(int i = 0; i < n; i++) {
            if(!marked[i]) return false;
        }
        return true;
    }
}
// BFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n <= 0 || edges == null) return false;
        // Initial graph
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
        // Add egdges
        for(int i = 0; i < edges.length; i++) {
            int v = edges[i][0], w = edges[i][1];
            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        // Check cycle
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] marked = new boolean[n];
        queue.offer(0);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            if(marked[v]) return false;
            marked[v] = true;
            for(int w : graph.get(v)) {
                queue.offer(w);
                graph.get(w).remove(v);
            }
        }
        // Check connected
        for(int i = 0; i < n; i++) {
            if(!marked[i]) return false;
        }
        return true;
    }
}
// Union Find
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n <= 0 || edges == null) return false;
        int[] vertices = new int[n];
        Arrays.fill(vertices, -1);
        for(int i = 0; i < edges.length; i++) {
            // Find root of each vertex
            int x = find(vertices, edges[i][0]);
            int y = find(vertices, edges[i][1]);
            // If two have same roots, they are already connected, so find cycle
            if(x == y) return false;
            // union two vertices
            vertices[x] = y;
        }
        // If connected
        return edges.length == n - 1;
    }
    
    private int find(int[] vertices, int i) {
        if(vertices[i] == -1) return i;
        return find(vertices, vertices[i]);
    }
}