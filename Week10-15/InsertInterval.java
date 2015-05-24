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
    //和merge interval一样，直接将要插入的先插入intervals中
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null) {
            intervals=new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> res=new ArrayList<Interval>();
        intervals.add(newInterval);
        Collections.sort(intervals,new IntervalComparator());
        Interval last=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval cur=intervals.get(i);
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