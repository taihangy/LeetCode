public class Solution {
    // Same as 210, and is easier
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        Digraph G = new Digraph(numCourses);
        for(int i = 0; i < prerequisites.length; i++) {
            for(int j = 0; j < prerequisites[i].length; j++) {
                G.addEdge(prerequisites[i][j], prerequisites[i][++j]);
            }
        }
        DetectCycle dc = new DetectCycle(G);
        return !dc.hasCycle();
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
        
        public DetectCycle(Digraph G) {
            marked = new boolean[G.V()];
            onStack = new boolean[G.V()];
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
            
            onStack[v] = false;
        }
        
        public boolean hasCycle() {
            return hasCycle;
        }
    }
}