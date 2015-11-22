public class Solution {
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        UF uf = new UF(m, n);
        for(int[] position : positions) {
            int x = position[0], y = position[1];
            int p = uf.add(x, y);
            for(int[] dir : dirs) {
                int q = uf.getID(x + dir[0], y + dir[1]);
                if(q > 0 && !uf.find(p, q))
                    uf.union(p, q);
            }
            res.add(uf.size());
        }
        return res;
    }
    
    private class UF {
        private int[] id;
        private int[] sz;
        private int count, m, n;
        
        public UF(int m, int n) {
            count = 0;
            this.m = m;
            this.n = n;
            id = new int[m * n + 1];
            sz = new int[m * n + 1];
        }
        
        public int index(int x, int y) {
            return x * n + y + 1;
        }
        
        public int getID(int x, int y) {
            if(x >= 0 && x < m && y >= 0 && y < n)
                return id[index(x, y)];
            return 0;
        }
        
        public int size() { return count; }
        
        public int add(int x, int y) {
            int index= index(x, y);
            id[index] = index;
            sz[index] = 1;
            count++;
            return index;
        }
        
        public boolean find(int p, int q) {
            return root(p) == root(q);
        }
        
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        private void union(int p, int q) {
            int rootp = root(p);
            int rootq = root(q);
            if(rootp == rootq) return;
            else if(sz[rootp] > sz[rootq]) {
                id[rootq] = rootp;
                sz[rootp] += sz[rootq];
                count--;
            } else {
                id[rootp] = rootq;
                sz[rootq] += sz[rootp];
                count--;
            }
        }
    }
   
}