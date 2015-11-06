public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0].length != 3) return res;
        return partitionBuildings(buildings, 0, buildings.length - 1);
    }
    
    private LinkedList<int[]> partitionBuildings(int[][] buildings, int i, int j) {
        if(i >= j) {
            LinkedList<int[]> res = new LinkedList<int[]>();
            res.add(new int[]{buildings[i][0], buildings[i][2]});
            res.add(new int[]{buildings[i][1], 0});
            return res;
        }
        int m = i + (j - i) / 2;
        LinkedList<int[]> left = partitionBuildings(buildings, i, m);
        LinkedList<int[]> right = partitionBuildings(buildings, m + 1, j);
        return merge(left, right);
    }
    
    private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {
        LinkedList<int[]> res = new LinkedList<int[]>();
        if(l1 == null || l1.size() == 0 || l2 == null || l2.size() == 0) return res;
        
        int h1 = 0, h2 = 0;
        while(l1.size() > 0 || l2.size() > 0) {
            if(l1.size() == 0) {
                res.addAll(l2);
                break;
            }
            if(l2.size() == 0) {
                res.addAll(l1);
                break;
            }
            int x = 0, h = 0;
            if(l1.getFirst()[0] < l2.getFirst()[0]) {
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
            }
            else if(l1.getFirst()[0] > l2.getFirst()[0]) {
                x = l2.getFirst()[0];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l2.removeFirst();
            } else {
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if(res.size() == 0 || res.getLast()[1] != h) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}