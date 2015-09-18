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


    // extensible & word.add will return a boolean value to indicate whether it has been added before
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> word = new HashSet<Integer>();
        Set<Integer> doubleWord = new HashSet<Integer>();
        List<String> res = new ArrayList<String>();
        char[] map = new char[256];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for(int i = 0; i < s.length() - 9; i++) {
            int sum = 0;
            for(int j = i; j <= i + 9; j++) {
                sum = sum * 4 + map[s.charAt(j) - 'A'];
            }
            if(!word.add(sum) && doubleWord.add(sum)) res.add(s.substring(i, i + 10));
        }
        return res;
    }
}