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
    public int minMeetingRooms(List<Interval> intervals) {
        int[] timeline = new int[1000001];
        for(Interval i: intervals){
            timeline[i.start] += 1;
            timeline[i.end] -= 1;
        }
        int clashes = 0, max = 0;
        for(int i = 0; i<timeline.length; i++){
            clashes += timeline[i];
            max = Math.max(max, clashes);
        }
        return max;
    }
}
