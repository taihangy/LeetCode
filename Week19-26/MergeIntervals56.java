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
    //O(nlogn + n), space O(1)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= last.end) {
                last.end = last.end < cur.end? cur.end : last.end;
            } else {
                res.add(last);
                last = cur;
            }
        }
        res.add(last);
        return res;
    }
}