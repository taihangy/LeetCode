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
        if(points==null||points.length==0) return 0;
        int max=1;
        HashMap<Double,Integer> map=new HashMap<Double,Integer>();
        for(int i=0;i<points.length;i++){
            map.clear();
            map.put((double)Integer.MIN_VALUE,1);
            int dup=0;
            for(int j=i+1;j<points.length;j++){
                if(points[j].x==points[i].x&&points[j].y==points[i].y){
                    dup++;
                    continue;
                }
                double slope=points[i].x==points[j].x?
                             (double)Integer.MAX_VALUE:0.0+(double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
                if(map.containsKey(slope)){
                    map.put(slope,map.get(slope)+1);
                }else{
                    map.put(slope,2);
                }
            }
            for(int temp:map.values()){
                if(temp+dup>max){
                    max=temp+dup;
                }
            }
        }
        return max;
    }
}