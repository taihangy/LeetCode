public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        //Char in s to Char in t
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> dup = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                char c = map.get(sc);
                if (c != tc) return false;
            }
            else {
                if (dup.add(tc)) {
                    map.put(sc, tc);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<String>> isomorphicStrings(String[] s) {
        List<List<String> res = new ArrayList<List<String>>();
        if (s == null || s.length == 0) return res;
        boolean[] marked = new boolean[s.length];
        for (int i = 0; i < s.length; i++) {
            List<String> list = new ArrayList<>();
            String pre = s[i];
            if (!marked[i] && pre != null) {
                marked[i] = true;
                list.add(pre);
                for (int j = i + 1; j < s.length; j++) {
                    String cur = s[i];
                    if (cur != null && cur.length() == pre.length()) {
                        if (isIsomorphic(pre, cur)) {
                            list.add(cur);
                        }
                    }
                }
                if (list.size() > 1) {
                    res.add(list);
                }
            }
        }
        return res;
    }

















}