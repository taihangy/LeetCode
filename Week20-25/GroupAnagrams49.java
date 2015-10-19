public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i = 0; i < strs.length; i++) {
            String a = strs[i];
            if(a == null) continue;
            strs[i] = null;
            List<String> l = new ArrayList<String>();
            l.add(a);
            for(int j = i + 1; j < strs.length; j++) {
                String b = strs[j];
                if(b == null) continue;
                if(isAnagram(a, b)) {
                    l.add(b);
                    strs[j] = null;
                }
            }
            res.add(l);
        }
        return res;
    }
    private static boolean isAnagram(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        String afterA = String.valueOf(ac);
        String afterB = String.valueOf(bc);
        return afterA.equals(afterB);
    }
}

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] sc = strs[i].toCharArray();
            Arrays.sort(sc);
            String after = String.valueOf(sc);
            List<String> list = new ArrayList<String>();
            if(map.containsKey(after)) {
                list = map.get(after);
            }
            list.add(strs[i]);
            map.put(after, list);
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}