public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0) return res;
        helper(res, num, "", target, 0, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String num, String item, int target, int index, long eval, long mul) {
        if(index == num.length()) {
            if(eval == target) {
                res.add(item);
            }
            return;
        }
        for(int i = index; i < num.length(); i++) {
            if(i != index && num.charAt(index) == '0') break;
            long cur = Long.parseLong(num.substring(index, i + 1));
            if(index == 0) {
                helper(res, num, item + cur, target, i + 1, cur, cur);
            }
            else {
                helper(res, num, item + '+' + cur, target, i + 1, eval + cur, cur);
                helper(res, num, item + '-' + cur, target, i + 1, eval - cur, -cur);
                helper(res, num, item + '*' + cur, target, i + 1, eval - mul + mul * cur, mul * cur);
            }
        }
    }
}