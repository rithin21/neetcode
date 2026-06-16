/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()<=1)
        {
            return true;
        }
        Collections.sort(intervals,Comparator.comparingInt(x->x.start));
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<end)
            {
                return false;
            }
            start=intervals.get(i).start;
            end=intervals.get(i).end;
        }
        return true;

    }
}
