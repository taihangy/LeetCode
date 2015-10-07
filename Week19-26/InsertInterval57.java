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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= last.end) {
                last.end = cur.end > last.end? cur.end : last.end;
            } else {
                res.add(last);
                last = cur;
            }
        }
        res.add(last);
        return res;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                       Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}