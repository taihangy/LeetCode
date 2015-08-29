public class Solution {
    public int nthUglyNumber(int n) {
        if(n < 4) return n;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        int ugly = 0;
        for(int i = 2; i <= n; i++) {
            ugly = pq.poll();
            while(set.contains(ugly)) {
                ugly = pq.poll();
            }
            set.add(ugly);
            pq.add(ugly > Integer.MAX_VALUE / 2 ?Integer.MAX_VALUE : 2 * ugly);
            pq.add(ugly > Integer.MAX_VALUE / 3 ?Integer.MAX_VALUE : 3 * ugly);
            pq.add(ugly > Integer.MAX_VALUE / 5 ?Integer.MAX_VALUE : 5 * ugly);
        }
        return ugly;
    }

    public int nthUglyNumber(int n) {
        if(n < 4) return n;
        ArrayList<Integer> queue2 = new ArrayList<Integer>();
        ArrayList<Integer> queue3 = new ArrayList<Integer>();
        ArrayList<Integer> queue5 = new ArrayList<Integer>();
        queue2.add(2);
        queue3.add(3);
        queue5.add(5);
        int ugly = 1;
        for(int i = 2; i <= n; i++) {
            int x = queue2.get(0);
            int y = queue3.get(0);
            int z = queue5.get(0);
            if(Math.min(Math.min(x, y), z) == x) {
                ugly = queue2.remove(0);
                queue2.add(ugly > Integer.MAX_VALUE / 2 ? Integer.MAX_VALUE : ugly * 2);
                queue3.add(ugly > Integer.MAX_VALUE / 3 ? Integer.MAX_VALUE : ugly * 3);
                queue5.add(ugly > Integer.MAX_VALUE / 5 ? Integer.MAX_VALUE : ugly * 5);
            } else if(Math.min(Math.min(x, y), z) == y) {
                ugly = queue3.remove(0);
                queue3.add(ugly > Integer.MAX_VALUE / 3 ? Integer.MAX_VALUE : ugly * 3);
                queue5.add(ugly > Integer.MAX_VALUE / 5 ? Integer.MAX_VALUE : ugly * 5);
            } else {
                ugly = queue5.remove(0);
                queue5.add(ugly > Integer.MAX_VALUE / 5 ? Integer.MAX_VALUE : ugly * 5);
            }
        }
        return ugly;
    }
}