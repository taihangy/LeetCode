public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10) return res;
        String ten = s.substring(0, 10);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(ten, 1);
        for(int i = 1; i < s.length() - 9; i++) {
            ten = s.substring(i, i + 10);
            if(map.containsKey(ten) && map.get(ten) == 1) {
                res.add(ten);
                map.put(ten, map.get(ten) - 1);
            } else if(map.containsKey(ten) && map.get(ten) == 0) {
                continue;
            } else {
                map.put(ten, 1);
            }
        }
        return res;
    }
}