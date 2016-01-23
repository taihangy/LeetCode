public class Solution {
	public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            if (cur.length() * cur.length() <= max) break;
            Set<Character> set = new HashSet<>();
            for (char c : cur.toCharArray()) {
                set.add(c);
            }
            for (int j = i + 1; j < words.length; j++) {
                String next = words[j];
                int k = 0;
                for (k = 0; k < next.length(); k++) {
                    char c = next.charAt(k);
                    if (set.contains(c)) break;
                }
                if (k == next.length()) {
                    max = Math.max(max, cur.length() * next.length());
                    break;
                }
            }
        }
        return max;
    }
}

public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        int n = words.length;
        int[] posOfChar = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                posOfChar[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            String pre = words[i];
            if (pre.length() * pre.length() <= max) break;
            for (int j = i + 1; j < n; j++) {
                String cur = words[j];
                if ((posOfChar[i] & posOfChar[j]) == 0) {
                    max = Math.max(max, pre.length() * cur.length());
                    break;
                }
            }
        }
        return max;
    }
}