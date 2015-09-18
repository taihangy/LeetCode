public class Solution {
    // dive and conquer
    // don't need to figure out every step, just know the outlet and the main body
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input == null || input.length() == 0) return res;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> first = diffWaysToCompute(input.substring(0, i));
                List<Integer> second = diffWaysToCompute(input.substring(i + 1));
                for(Integer f : first) {
                    for(Integer s : second) {
                        if(c == '+') res.add(f + s);
                        else if(c == '-') res.add(f - s);
                        else res.add(f * s);
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}