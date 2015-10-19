public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 1 || isPrime(n)) return res;
        helper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int n, int start) {
        if(n <= 1) {
            if(list.size() > 1) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = start; i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                helper(res, list, n/i, i);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPrime(int n) {
        assert n >= 2;
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}