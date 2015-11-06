
/** DFS uses preprocessing time and space proportional to V􏰟E to support constant-time connectivity queries in a graph.
*/
public class ConnectedComponents {
	private int count;
	private int[] id;
	private boolean[] marked;

	public ConnectedComponents(Graph G) {
		id = new int[G.V()];
		count = 0;
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++) {
			if(!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

}