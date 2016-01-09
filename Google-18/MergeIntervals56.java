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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }
}