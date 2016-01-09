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
        if (newInterval == null) return intervals;
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
                                       Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }
}

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
        if (newInterval == null) return intervals;
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        intervals.add(newInterval);
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (last.end >= cur.start) {
                last.end = Math.max(cur.end, last.end);
            } else {
                res.add(last);
                last = cur;
            }
        }
        res.add(last);
        return res;
    }
}