public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strings.length; i++) {
            String cur = strings[i];
            int gap = cur.charAt(0) - 'a';
            StringBuilder trans = new StringBuilder();
            if(gap != 0) {
                for(int j = 0; j < cur.length(); j++) {
                    char c = (char)(cur.charAt(j) - gap);
                    c = c < 'a'? (char)(cur.charAt(j) + 26 - gap) : c;
                    trans.append(c);
                }
            }
            String now = gap == 0? cur : trans.toString();
            List<String> list = new ArrayList<String>();
            if(map.containsKey(now)) {
                list = map.get(now);
            }
            list.add(cur);
            map.put(now, list);
        }
        for(List<String> list : map.values()) {
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}