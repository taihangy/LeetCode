/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 1;
        for(int i = 0; i < points.length; i++) {
            map.clear();
            map.put(Double.MIN_VALUE, 1);
            int dup = 0;
            Point pi = points[i];
            for(int j = i + 1; j < points.length; j++) {
                Point pj = points[j]; 
                if(pi.x == pj.x && pi.y == pj.y) {
                    dup++;
                    continue;
                }
                double slope = pi.x == pj.x?Double.MAX_VALUE : 0.0 + (double)(pj.y - pi.y) / (pj.x - pi.x);
                if(map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                }else {
                    map.put(slope, 2);
                }
            }
            for(int oneline : map.values()) {
                max = Math.max(max, dup + oneline);
            }
        }
        return max;
    }
}