public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return res;
        helper(digits, 0, "", res);
        return res;
    }
    
    private void helper(String digits, int index, String seg, List<String> res) {
        if (index >= digits.length()) {
            res.add(seg);
            return;
        }
        int number = digits.charAt(index) - '0';
        String str = numToStr(number);
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                helper(digits, index + 1, seg + str.charAt(i), res);
            }
        }
        else {
            helper(digits, index + 1, seg, res);
        }
    }
    
    private String numToStr(int num) {
        switch(num) {
            case 0:
                return "";
            case 1:
                return "";
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return null;
    }
}