/** Union Find Weighted Quick union with path compression*/
public class UF {
    private int[] id; // identifier of each site
    private int[] size; // size of each site
    private int count; // number of connected components
    
    /** Constructor: initialize count to N, size to 1 and id to itself*/
    public UF(int N) {
        this.id = new int[N];
        this.size = new int[N];
        this.count = N;
        for(int i = 0; i < N; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }
    
    /** Return the number of connected component*/
    public int count() { return count; }

    /** Return whether p is connected with q
    * Precondition: p and q are in range 0..N - 1
    */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    /** Return the identifier of p
    * Precondition: p is in range 0..N - 1
    */
    public int find(int p) {
        while(p != id[p]) {
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }
        return p;
    }
    
    /** Connect p with q
    * Precondition: p and q are in range 0..N - 1
    */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        // weighted size compare
        if(size[p] < size[q]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}