public class Solution {
    // same as pascalTriangle1
    public List<Integer> getRow(int rowIndex) {
        List<Integer> first = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return first;
        }
        first.add(1);
        if(rowIndex == 0) {
            return first;
        }
        List<Integer> second = null;
        for(int i = 0; i < rowIndex; i++){
            second = new ArrayList<Integer>();
            second.add(1);
            if(first.size() != 1) {
                for(int j = 0; j < first.size() - 1; j++){
                    int sum = first.get(j) + first.get(j + 1);
                    second.add(sum);
                }
            }
            second.add(1);
            first = second;
        }
        return second;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) return res;
        res.add(1);
        if(rowIndex == 0) return res;
        res.add(1);
        if(rowIndex == 1) return res;
        for(int i = 2; i <= rowIndex; i++) {
            int size = res.size();
            for(int j = size - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }
        return res;
    }
}