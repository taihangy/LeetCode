/** BFS
* Time worst case E + V, find shortest path from source s to given node
*/
public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s); 
    }

    private void bfs(Graph G, int v) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        marked[v] = true;
        queue.offer(v);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}