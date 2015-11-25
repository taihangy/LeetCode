public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        for(int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);
            if(sub.equals("++")) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i)).append("--").append(s.substring(i + 2));
                res.add(sb.toString());
            }
        }
        return res;
    }
}