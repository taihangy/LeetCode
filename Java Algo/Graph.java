import java.util.List;

public class Graph {
	private final int V;
	private int E;
	private List<Integer>[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (ArrayList<Integer>)new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
	}

	public int V() {  return V;  }
    public int E() {  return E;  }

    public void addEdge(int v, int w) {
    	adj[v].add(w);
        adj[w].add(v);
    	E++;
    }

    public Iterable<Integer> adj(int v) {
    	return adj[v];
    }
}