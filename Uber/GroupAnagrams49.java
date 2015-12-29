public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return res;
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String before = strs[i];
            char[] array = before.toCharArray();
            Arrays.sort(array);
            String after = String.valueOf(array);
            List<String> list = new ArrayList<String>();
            if(map.containsKey(after)) {
                list = map.get(after);
            }
            list.add(before);
            map.put(after, list);
        }
        for (List<String> l : map.values()) {
            res.add(l);
        }
        return res;
    }
}