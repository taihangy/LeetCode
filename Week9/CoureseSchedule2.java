public class Solution {
    private boolean[] marked;
    private boolean[] onStack;
    private boolean cycle;
    private LinkedList<Integer> reversePost;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Digraph G=new Digraph(numCourses);
        for(int i=0;i<prerequisites.length;i++)
        	for(int j=0;j<prerequisites[0].length;j+=2){
                G.addEdge(prerequisites[i][j+1],prerequisites[i][j]);
            }
        marked=new boolean[G.V()];
        onStack=new boolean[G.V()];
        reversePost=new LinkedList<Integer>();
        
        for(int v=0;v<G.V();v++){
            if(!marked[v]) dfs(G,v);
            if(hasCycle()) break;
        }
        return path(numCourses);
    }
    
    private void dfs(Digraph G,int v){
        marked[v]=true;
        onStack[v]=true;
        
        for(int w:G.adj(v)){
            if(this.hasCycle()) return;
            else if(!marked[w]){
                dfs(G,w);
            }else if(onStack[w]){
                cycle=true;
                break;
            }
        }
        if(!reversePost.contains(v))
        	reversePost.push(v);
        onStack[v]=false;
    }
    
    private int[] path(int numCourses){
        if(hasCycle()) {
            int[] res={};
            return res;
        }
        int i=0;
        int[] res=new int[numCourses];
        while(!reversePost.isEmpty()){
            res[i++]=reversePost.pop();
        }
        return res;
    }
    
    public boolean hasCycle(){
        return cycle;
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
    
}