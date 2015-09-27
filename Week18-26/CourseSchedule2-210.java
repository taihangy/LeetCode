public class Solution {
    // DAG, Topological sort, summary respectively
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Construct Digraph
        Digraph G = new Digraph(numCourses);
        for(int i = 0; i < prerequisites.length; i++) {
            for(int j = 0; j < prerequisites[i].length; j += 2) {
                G.addEdge(prerequisites[i][j + 1], prerequisites[i][j]);
            }
        }
        // Detect Cycle
        DetectCycle dc = new DetectCycle(G);
        if(dc.hasCycle()) return new int[]{};
        // reversePost order
        int[] res = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++) {
            res[i] = dc.path.pop();
        }
        return res;
    }
    
    public class Digraph {
        private ArrayList<Integer>[] adj;
        private int V;
        
        public Digraph(int V) {
            this.V = V;
            this.adj = (ArrayList<Integer>[]) new ArrayList[V];
            for(int i = 0; i < V; i++) {
                adj[i] = new ArrayList<Integer>();
            }
        }
        
        public void addEdge(int v, int w) {
            adj[v].add(w);
        }
        
        public int V() {
            return V;
        }
        
        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }
    
    public class DetectCycle {
        private boolean[] marked;
        private boolean[] onStack;
        private boolean hasCycle;
        private Stack<Integer> path;
        
        public DetectCycle(Digraph G) {
            marked = new boolean[G.V()];
            onStack = new boolean[G.V()];
            path = new Stack<Integer>();
            hasCycle = false;
            for(int i = 0; i < G.V(); i++) {
                if(!marked[i]) {
                    dfs(i, G);
                    if(hasCycle) break;
                }
            }
        }
        
        private void dfs(int v, Digraph G) {
            marked[v] = true;
            onStack[v] = true;
            
            for(int w : G.adj(v)) {
                if(hasCycle) break;
                if(!marked[w]){
                    dfs(w, G);
                } 
                else if(onStack[w]) {
                    hasCycle = true;
                    break;
                }
            }
            path.push(v);
            onStack[v] = false;
        }
        
        public boolean hasCycle() {
            return hasCycle;
        }
        
        public Iterable<Integer> path() {
            return path;
        }
    }
}