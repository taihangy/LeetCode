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
}