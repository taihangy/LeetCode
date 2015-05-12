public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0||prerequisites[0].length==0) return true;
        Digraph G=new Digraph(numCourses);
        for(int i=0;i<prerequisites.length;i++)
            for(int j=0;j<prerequisites[0].length;j++)
                G.addEdge(prerequisites[i][j],prerequisites[i][++j]);
        DetectCycle dc=new DetectCycle(G);
        return !dc.hasCycle();
    }
   
    private class Digraph{
        private final int V;
        private ArrayList<Integer>[] adj;
        public Digraph(int V){
            this.V=V;
            adj=(ArrayList<Integer>[])new ArrayList[V];
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList<Integer>();
        }
        public void addEdge(int v,int w){
            adj[v].add(w);
        }
        public int V(){
            return V;
        }
        public Iterable<Integer> adj(int v){
            return adj[v];
        }
    }
    
    private class DetectCycle{
        private boolean[] marked;
        private boolean[] onStack;
        private boolean hasCycle;
        
        public DetectCycle(Digraph G){
            marked=new boolean[G.V()];
            onStack=new boolean[G.V()];
            hasCycle=false;
            for(int v=0;v<G.V();v++){
                if(!marked[v]) dfs(v,G);
                if(hasCycle) break;
            }
        }
        
        private void dfs(int v,Digraph G){
            marked[v]=true;
            onStack[v]=true;
            for(int w:G.adj(v)){
                if(hasCycle) return;
                else if(!marked[w]){
                    dfs(w,G);
                }
                else if(onStack[w]){
                    hasCycle=true;
                    break;
                }
            }
            onStack[v]=false;
        }
        
        public boolean hasCycle(){
            return hasCycle;
        }
    }
}