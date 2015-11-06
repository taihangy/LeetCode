import java.util.List;

public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private List<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (ArrayList<DirectedEdge>)new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<DirectedEdge>();
	}

	public int V() {  return V;  }
    public int E() {  return E;  }

    public void addEdge(DirectedEdge e) {
    	adj[e.from()].add(e);
    	E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
    	return adj[v];
    }

    public Iterable<DirectedEdge> edge() {
    	ArrayList<DirectedEdge> res = new ArrayList<DirectedEdge>();
    	for(int v = 0; v < V; v++) {
    		res.addAll(adj[v]);
    	}
    	return res;
    }

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(3);
	}
}