/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    //time complexity O(nlogn+n),space O(1)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0) return res;
        //sort by interval's start
        Collections.sort(intervals,new IntervalComparator());
        Interval last=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval cur=intervals.get(i);
            //overlapped, so merge
            if(cur.start<=last.end){
                last.end=Math.max(cur.end,last.end);
            }else{
                res.add(last);
                last=cur;
            }
        }
        res.add(last);
        return res;
    }
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a,Interval b){
            return a.start-b.start;
        }
    }
}