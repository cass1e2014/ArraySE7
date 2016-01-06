import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * 
 * @author cassie9082
 * 
 */
public class MeetingRooms {
    //The problem looks very similar to the merge interval and insert intervals. 
	//So the idea is still the same: first sort the intervals according to the start times, then check if there is any overlap. 
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        
        Arrays.sort(intervals, intervalComparator);
        Interval prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            Interval curr = intervals[i];
            if(prev.end > curr.start){
                return false;
            }
            prev = curr;
        }
        return true;
    }
    
    public Comparator<Interval> intervalComparator = new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    };
}
