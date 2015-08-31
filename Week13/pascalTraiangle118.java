public class Solution {
    // be careful of corner cases like numRows == 0 or 1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return res;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        if(numRows == 1) {
            return res;
        }
        for(int i = 1; i < numRows; i++) {
            List<Integer> second = new ArrayList<Integer>();
            second.add(1);
            if(first.size() != 1) {
                for(int j = 0; j < first.size() - 1; j++) {
                    int sum = first.get(j) + first.get(j + 1);
                    second.add(sum);
                }
            }
            second.add(1);
            first = second;
            res.add(second);
        }
        return res;
    }
}