public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int i = -1, count = 0, N = nodes.length;
        while (++i < N - 1) {
            if (!"#".equals(nodes[i])) count++;
            else if (--count < 0) return false;
        }
        return count == 0 && "#".equals(nodes[N - 1]);
    }

    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}