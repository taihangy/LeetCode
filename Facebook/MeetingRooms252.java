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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for(int i = 0; i < intervals.length - 1; i++) {
            Interval cur = intervals[i];
            Interval next = intervals[i + 1];
            if(cur.end > next.start) return false;
        }
        return true;
    }
}