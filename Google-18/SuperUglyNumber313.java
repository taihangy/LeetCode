public class Solution {
    // TIME: O(n), Space: O(n)
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0) return 0;
        int[] res = new int[n];
        res[0] = 1;
        // Record the index of smallest product of every element in primes from the last step, e.g. the first step the smallest product is 2, 7, 13, 19 (its index is 0), the second step is 4 (index 1), 7 (index 0), 13 (index 0), 19 (idnex 0), the third step is 4 (1), 7 (1), 13(0), 19(0)
        int[] indexes = new int[primes.length];
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], res[indexes[j]] * primes[j]);
            }
            
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == primes[j] * res[indexes[j]]) {
                    indexes[j]++;
                }
            }
        }
        return res[n - 1];
    }

    // TLE TIME: O(k + nLogn) k = primes.length, Space: O(n)
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0) return 0;
        if (n == 1) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashSet<Integer> dup = new HashSet<Integer>();
        for (int prime : primes) {
            pq.offer(prime);
        }
        for (int i = 1; i < n - 1; i++) {
            int min = pq.poll();
            for (int j = 0; j < primes.length; j++) {
                if (dup.add(min * primes[j]))
                    pq.offer(primes[j] * min);
            }
        }
        return pq.poll();
    }
}