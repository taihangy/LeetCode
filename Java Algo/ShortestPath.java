/**
* Shortest path algorithm
* The classic Dijkstra’s algorithm for the problem when weights are nonnegative
*
* A faster algorithm for acyclic edge-weighted digraphs (edge-weighted DAGs)
* that works even when edge weights can be negative
*
* The classic Bellman-Ford algorithm for use in the general case, when cycles may
* be present, edge weights may be negative, and we need algorithms for finding negative-weight cycles and shortest paths in edge-weighted digraphs with no such cycles
*/
//ElogV time
public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for(int i = 0; i < distTo.length; i++) 
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq = new IndexMinPQ<Double>(G.V());

		pq.insert(s, 0.0);
		while(!pq.isEmpty()) {
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for(DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w] > distTo[v] + e.wight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> edgeTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[v.from()]) {
			path.push(e);
		}
		return path;
	}
}

//All pairs shortest path EVlogV time
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;
    
    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()]
        for (int v = 0; v < G.V(); v++)
        	all[v] = new DijkstraSP(G, v);
    }
     
    public Iterable<Edge> path(int s, int t) {  
    	return all[s].pathTo(t);  
    }

    public double dist(int s, int t) {  
    	return all[s].distTo(t);  
    }
}